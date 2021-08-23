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
    BE_ORDERS,
    RESOURCE_DEL,
    BE_TRANSACTION
} from "../constants/globalConstants.jsx";

class TransactionSubmit extends Component {
    constructor(props) {
        console.log("props");
        console.log(props.location.state);
        super(props);
        this.state = {
            redirect: null,
            nombres: props.location.state.orderInfo.nombreCliente,
            apellidos: props.location.state.orderInfo.apellidoCliente,
            email: props.location.state.orderInfo.emailCliente,
            celular: props.location.state.orderInfo.movilCliente,
            estado: props.location.state.orderInfo.statusTransaccion,
            idOrden: props.location.state.orderInfo.id,
        };
        this.createTransaction = this.createTransaction.bind(this);
    }

    createTransaction(e){
        axios.post(
            URL_BACKEND + BE_ORDERS + RESOURCE_DEL + this.state.idOrden + BE_TRANSACTION
        ).then((data) => {
            window.location.href = data.data
        });
    }

    render(){
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
                <Col md={{size:2, offset:2}}>
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
                        <Button onClick={this.createTransaction}>Pagar</Button>
                    </Col>
                </Row>
            </Container>
        )
    }
}

export default TransactionSubmit;