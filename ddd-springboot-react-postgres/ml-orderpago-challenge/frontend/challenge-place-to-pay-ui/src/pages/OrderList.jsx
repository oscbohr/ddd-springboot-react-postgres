import React, {Component} from 'react';
import {
    Container,
    Button,
    Row,
    Col,
    Card,
    CardImg,
    CardBody,
    CardTitle,
    CardSubtitle
} from "reactstrap";
import tire from "../assets/tire.png"
import rin from "../assets/rin.jpeg"
import axios from "axios";
import {
    URL_BACKEND,
    BE_ORDERS
} from "../constants/globalConstants.jsx";
import { Redirect } from "react-router-dom";
import history from "../utils/history";


class OrderList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            orders: [],
            ordersMap: []
        };
        this.goOrderSubmit = this.goOrderSubmit.bind(this);
        this.createTransaction = this.createTransaction.bind(this);
    }

    componentDidMount(){
        axios.get(URL_BACKEND + BE_ORDERS).then((data) => {
            console.log(data.data);
            this.setState({
                orders: data.data
            })
            this.setState({
                ordersMap: data.data.reduce(function(map, obj){
                    map[obj.id] = obj;
                    return map;
                }, [])
            })
        });
    }

    goOrderSubmit(){
        history.push({
            pathname: "crearOrden",
        });
    }

    createTransaction(e){
        console.log(e.target.id);
        console.log(this.state.ordersMap);
        console.log(this.state.ordersMap[e.target.id]);
        history.push({
            pathname: "orden/" + e.target.id + "/transaccion",
            state: {
                orderInfo: this.state.ordersMap[e.target.id]
            }
        });
    }

    render(){
        return(
            <Container>
                <Row>
                    <Col>
                        <Button onClick={this.goOrderSubmit}>
                            Nueva Orden
                        </Button>
                    </Col>
                </Row>
                {this.state.orders.map(order =>(
                    <>
                        <Row>
                            <Col>Order ID: {order.id}</Col>
                            <Col>Estado: {order.statusTransaccion}</Col>
                        </Row>
                        <Row>
                            <Col>Nombres: {order.nombreCliente}</Col>
                            <Col>Apellidos: {order.apellidoCliente}</Col>
                        </Row>
                        <Row>
                            <Col>Email: {order.emailCliente}</Col>
                            <Col>Celular: {order.movilCliente}</Col>
                        </Row>
                        <Row>
                            <Col md={{size:2, offset:1}}>
                                <Card>
                                    <CardImg top width="50px" src={tire} alt="Card image cap" />
                                    <CardBody>
                                        <CardTitle tag="h5">Llanta GitiPremium H1</CardTitle>
                                        <CardSubtitle tag="h6" className="mb-2 text-muted">Llanta para uso en carretera $200.000 COP</CardSubtitle>
                                        
                                    </CardBody>
                                </Card>
                            </Col>
                            <Col md={2}>
                                <Card>
                                    <CardImg top width="50px" src={rin} alt="Card image cap" />
                                    <CardBody>
                                        <CardTitle tag="h5">Rin Dark Gun Metal Machined Face</CardTitle>
                                        <CardSubtitle tag="h6" className="mb-2 text-muted">RIN 19x8.5 5/120 ET +35 B 72.56 $300.000 COP</CardSubtitle>
                                        
                                    </CardBody>
                                </Card>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <Button id={order.id} onClick={this.createTransaction}
                                    disabled={order.statusTransaccion === "PAYED"}>
                                        Pagar
                                </Button>
                            </Col>
                        </Row>
                    </>
                ))}
            </Container>
        )
    }
}

export default OrderList;