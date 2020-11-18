import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import List from "./component/List";
import Header from "./component/Header";
import Add from "./component/Add";
import Update from "./component/Update";
import Detail from "./component/Detail";

function App() {
  return (
      <div>
          <Router>
              <div className="container">
                <Header/>
                  <Switch>
                      <Route path="/" exact component={List}></Route>
                      <Route path="/product" component={List}></Route>
                      <Route path="/add" component={Add}></Route>
                      <Route path="/update/:id" component={Update}></Route>
                      <Route path="/product-detail/:id" component={Detail}></Route>
                      <List />
                  </Switch>
              </div>
          </Router>
      </div>
  );
}

export default App;
