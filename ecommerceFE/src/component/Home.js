import React from "react";
import "./Home.css";
import ProductPanel from "./ProductPanel";
import NavBar from "./NavBar";
import movement from "../logic/movement";
import ProductDetails from "./ProductDetails";
import Login from "./Login";
import MyOrders from "./MyOrders"

export default class Home extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            products: [],
            orders: [],
            login: false,
            myOrders: false,
            showing: null,
            details: false,
            userId: this.props.user,
        };
    }

    handleClick = (buttonName, iden) => {
        this.setState(movement(this.state, buttonName, iden));
      };
    
    
    render(){
        if(this.state.login){
            return(
                <div>
                <Login/>
                </div>
            );
        }else if(this.state.myOrders){
            return(
                <div>
                <NavBar clickHandler={this.handleClick}/>              
                <br/>
                <MyOrders clickHandler={this.handleClick} orders={this.state.orders}/>
                </div>
            );
        }else if(this.state.details){
            return(
                <div>
                    <NavBar clickHandler={this.handleClick}/>
                    <ProductDetails user={this.state.userId} single={this.state.showing} clickHandler={this.handleClick}/>
                </div>
            );
        }
        
        else{
            return(
                <div>
                    <NavBar clickHandler={this.handleClick}/>              
                    <br/>
                    <ProductPanel clickHandler={this.handleClick} products={this.state.products}/>
                </div>

                
            );
        }
    }

    componentDidMount(){
        fetch('http://localhost:8080/AnankeSpring/api/products')
        .then(response => response.json())
        .then(json => {
            console.log(json);
            this.setState({products: json});
        });
    }

}
