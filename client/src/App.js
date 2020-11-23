import './App.css';
import React from "react";
import Detail from "./component/Detail";
import Header from "./component/Header";
import Category from "./component/Category";
import Login from "./component/Login";
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import Menu from "./component/Menu";



function App() {

    return (
        <div>
            <Header/>
            <br/>
            <Router>
                <Switch>
                    <Route path="/" exact component={Login}></Route>
                    <Route path="/product" component={Category}></Route>
                    <Route path="/menu"  component={Menu}></Route>
                </Switch>
            </Router>

        </div>
    );
}
export default App;
