import axios from 'axios';
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
import {
    URL_BACKEND,
    BE_ORDERS,
    RESOURCE_DEL,
    BE_TRANSACTION
} from "../constants/globalConstants.jsx";
import { Redirect } from "react-router-dom";

class OrderDetail extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nombres: "",
            apellidos: "",
            email: "",
            celular: "",
            estado: "",
            idOrden: "",
            redirect: null
        };
        this.createTransaction = this.createTransaction.bind(this);
        this.goToHome = this.goToHome.bind(this);
    }

    componentDidMount(){
        axios.get(
            URL_BACKEND + BE_ORDERS + RESOURCE_DEL + this.props.match.params.orderId
        ).then((data) => {
            console.log(data.data);
            this.setState({
                nombres: data.data.nombreCliente,
                apellidos: data.data.apellidoCliente,
                email: data.data.emailCliente,
                celular: data.data.movilCliente,
                estado: data.data.statusTransaccion,
                idOrden: data.data.id
            });
        });
    }

    createTransaction(e){
        axios.post(
            URL_BACKEND + BE_ORDERS + RESOURCE_DEL + this.state.idOrden + BE_TRANSACTION
        ).then((data) => {
            window.location.href = data.data
        });
    }

    goToHome(){
        this.setState({
            redirect: "/"
        });
    }

    render(){
        if (this.state.redirect) {
            return <Redirect to={this.state.redirect} />
        }
        return(
            <Container>
                <Row>
                    <Col>Order ID: {this.state.idOrden}</Col>
                    <Col>Estado: {this.state.estado}</Col>
                </Row>
                <Row>
                    <Col>Nombres: {this.state.nombres}</Col>
                    <Col>Apellidos: {this.state.apellidos}</Col>
                </Row>
                <Row>
                    <Col>Email: {this.state.email}</Col>
                    <Col>Celular: {this.state.celular}</Col>
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
                    <Col md={{size:2, offset:2}}>
                        <Button onClick={this.createTransaction}
                            disabled={this.state.estado === "PAYED"}>
                                Pagar
                            </Button>
                    </Col>
                    <Col md={{size:2, offset:1}}>
                        <Button onClick={this.goToHome}>Ir al inicio</Button>
                    </Col>
                </Row>
            </Container>
        )
    }
}

export default OrderDetail;