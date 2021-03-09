import './App.css';
import Login from './Login';
import Registration from './Registration';
import Home from './Home';
import Products from './Products';
import Orders from './Orders';
import CartItems from './CartItems';
import { BrowserRouter, Route } from "react-router-dom";
import React from 'react';

class App extends React.Component {

  constructor(props){
    super(props)
  }

  render(){
    return (
    /*
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
    */
    <div>
      <BrowserRouter>
			  <div>

          <Route exact path="/" render={(props) => <Login {...props}/>}/>

				  <Route exact path="/registration" component={Registration}/>
          <Route exact path="/home" component={Home}/>
          <Route exact path="/products" component={Products}/>
          <Route exact path="/orders" component={Orders}/>
          <Route exact path="/cart" component={CartItems}/>
			  </div>
			</BrowserRouter>

    </div>
    );
  }
  
}
//<Route exact path="/" component={Login}/>
export default App;
