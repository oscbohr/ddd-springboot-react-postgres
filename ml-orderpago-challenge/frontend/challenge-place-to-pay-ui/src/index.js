import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Home from "./pages/Home.jsx"
import * as serviceWorker from './serviceWorker';
import {Router, Route, Switch } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import history from "./utils/history";

ReactDOM.render(
    <Router history={history}>
        <Switch>
            <Route path="/" component={Home} />
        </Switch>
    </Router>
    , document.getElementById('root')
);
serviceWorker.register();
