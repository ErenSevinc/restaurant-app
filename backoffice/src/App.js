import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import List from "./component/product/List";
import Header from "./component/Header";
import Add from "./component/product/Add";
import Update from "./component/product/Update";
import Detail from "./component/product/Detail";
import UserList from "./component/user/UserList";
import UserAdd from "./component/user/UserAdd";
import UserUpdate from "./component/user/UserUpdate";
import UserDetail from "./component/user/UserDetail";
import Order from "./component/order/Order";
import Login from "./component/Login";
import AuthList from "./component/user/AuthList";
import AuthUpdate from "./component/user/AuthUpdate";

function App() {
  return (
      <div>
          <Header/>
          <Router>
              <div className="container">
                  <Switch>
                      <Route path="/" exact component={Login}></Route>
                      <Route path="/product" component={List}></Route>
                      <Route path="/add" component={Add}></Route>
                      <Route path="/update/:id" component={Update}></Route>
                      <Route path="/product-detail/:id" component={Detail}></Route>
                      <Route path="/order" component={Order}></Route>
                      <Route path="/user" component={UserList}></Route>
                      <Route path="/user-add" component={UserAdd}></Route>
                      <Route path="/user-update/:id" component={UserUpdate}></Route>
                      <Route path="/user-detail/:id" component={UserDetail}></Route>
                      <Route path="/auth" component={AuthList}></Route>
                      <Route path="/auth-update/" component={AuthUpdate}></Route>
                      <List />
                  </Switch>
              </div>
          </Router>
      </div>
  );
}

export default App;
