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
import Category from "./component/category/Category";
import CategoryAdd from "./component/category/CategoryAdd";
import CategoryUpdate from "./component/category/CategoryUpdate";
import CategoryDetail from "./component/category/CategoryDetail";
import PrdouctListByCategory from "./component/category/PrdouctListByCategory";
import Info from "./component/info-app-properties/Info";
import TableCategoryList from "./component/table-category/TableCategoryList";
import TableCategoryAdd from "./component/table-category/TableCategoryAdd";
import TableCategoryUptade from "./component/table-category/TableCategoryUptade";
import TableCategoryDetail from "./component/table-category/TableCategoryDetail";
import TableList from "./unused/table/TableList";
import TableAdd from "./unused/table/TableAdd";
import WaiterList from "./component/waiter/WaiterList";
import WaiterAdd from "./component/waiter/WaiterAdd";
import WaiterDetail from "./component/waiter/WaiterDetail";
import WaiterUpdate from "./component/waiter/WaiterUpdate";
import MediaComponent from "./component/media/MediaComponent";
import UserContext, {UserContextProvider} from "./UserContext";
//localStorage.setItem("token",("Basic"+btoa('eren:1234')))

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
                      <Route path="/category" component={Category}></Route>
                      <Route path="/product-by-category/:id"component={PrdouctListByCategory}></Route>
                      <Route path="/category-add" component={CategoryAdd}></Route>
                      <Route path="/category-update/:id" component={CategoryUpdate}></Route>
                      <Route path="/category-detail/:id" component={CategoryDetail}></Route>
                      <Route path="/app-properties" component={Info}></Route>
                      <Route path="/table-category-list" component={TableCategoryList}></Route>
                      <Route path="/table-category-add" component={TableCategoryAdd}></Route>
                      <Route path="/table-category-update/:id" component={TableCategoryUptade}></Route>
                      <Route path="/table-category-detail/:id" component={TableCategoryDetail}></Route>
                      <Route path="/waiter" component={WaiterList}></Route>
                      <Route path="/waiter-add" component={WaiterAdd}></Route>
                      <Route path="/waiter-detail/:id" component={WaiterDetail}></Route>
                      <Route path="/waiter-update/:id" component={WaiterUpdate}></Route>
                      <Route path="/image" component={MediaComponent}></Route>
                      <List />
                  </Switch>
              </div>
          </Router>
      </div>
  );
}

export default App;
