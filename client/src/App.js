import './App.css';
import React from "react";
import Detail from "./component/Detail";
import Header from "./component/Header";
import Category from "./component/Category";
import Login from "./component/Login";
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import Menu from "./component/Menu";
import TableList from "./component/TableList";
import CategotyNew from "./component/CategotyNew";
import CategoryNews2 from "./component/CategoryNews2";
import CustomerAdd from "./component/CustomerAdd";



function App() {

    return (
        <div>
            <Header/>
            <br/>
            <Router>
                <Switch>
                    <Route path="/" exact component={Login}></Route>
                    <Route path="/products" component={CategotyNew}></Route>
                    <Route path="/menu"  component={Menu}></Route>
                    <Route path="/table" component={TableList}></Route>
                    <Route path="/new" component={CategoryNews2}></Route>
                    <Route path="/customer-add" component={CustomerAdd}></Route>
                </Switch>
            </Router>

        </div>
    );
}
export default App;
