import React, {Component} from 'react';
import {
    Container,
    Form,
    FormGroup,
    Label,
    Input,
    Button
} from "reactstrap";
import axios from "axios";
import {
    URL_BACKEND,
    BE_ORDERS
} from "../constants/globalConstants.jsx";
import history from "../utils/history";

class OrderSubmit extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nombres: "",
            apellidos: "",
            email: "",
            celular: "",
            redirect: null
        };
        this.createOrder = this.createOrder.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    createOrder(e){
        axios.post(
            URL_BACKEND + BE_ORDERS,
            {
                "nombreCliente": this.state.nombres,
                "apellidoCliente": this.state.apellidos,
                "emailCliente": this.state.email,
                "movilCliente": this.state.celular
            }
        ).then((data) => {
            console.log(data);
            history.push({
                pathname: "orden/" + data.data.id + "/transaccion",
                state: {
                    orderInfo: data.data
                }
            });
        });
    }

    render(){
        return(
            <Container>
                <Form onSubmit={this.createOrder}>
                    <FormGroup>
                        <Label for="nombres">Nombres:</Label>
                        <Input id="nombres" name="nombres" value={this.state.nombres}
                            onChange={this.handleChange}></Input>
                        <Label for="apellidos">Apellidos:</Label>
                        <Input id="apellidos" name="apellidos" value={this.state.apellidos}
                            onChange={this.handleChange}></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Email:</Label>
                        <Input id="email" name="email" value={this.state.email}
                            onChange={this.handleChange}></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="celular">Celular:</Label>
                        <Input id="celular" name="celular" value={this.state.celular}
                            onChange={this.handleChange}></Input>
                    </FormGroup>
                    <Button onClick={this.createOrder}>Submit</Button>
                </Form>
            </Container>
        )
    }
}

export default OrderSubmit;