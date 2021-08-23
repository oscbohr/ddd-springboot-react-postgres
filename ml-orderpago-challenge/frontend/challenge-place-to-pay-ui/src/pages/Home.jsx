import React, { Component } from 'react';
import { Route, Router, Switch } from "react-router-dom";
import history from "../utils/history"
import OrderSubmit from "./OrderSubmit"
import OrderList from "./OrderList"
import OrderDetail from "./OrderDetail"
import TransactionSubmit from "./TransactionSubmit"


class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
        };
    }

    componentDidMount() {
        document.title = "Evertec";
    }

    render() {
        return (
                <Router history={history}>
                    <Switch>
                        <Route exact path="/" component={OrderList} />
                        <Route exact path="/crearOrden" component={OrderSubmit} />
                        <Route exact path="/orden/:orderId" component={OrderDetail} />
                        <Route exact path="/orden/:orderId/transaccion" component={TransactionSubmit} />
                    </Switch>
                </Router>
        );
    }
}

export default Home;
