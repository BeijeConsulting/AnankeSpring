import React from 'react';
import ReactDOM from 'react-dom';
import './Navbar.css';
import LoginButton from './LoginButton';
import LogoutButton from './LogoutButton';
import RegisterButton from './RegisterButton';
import CartButton from './CartButton';

/*import {userContext} from './userContext.js';
import {checkLoggedUser} from './userContext.js';*/

export default class Navbar extends React.Component {
    render() {
        const className="Navbar";
        console.log('user dall navbar', this.props.value);
        if (this.props.value!== undefined && this.props.value !== null && this.props.value.id !== 0) {
            return (
                <div className={className}>
                    <a href="./home">Home</a>
                    <a href="./orders">Orders</a>
                    <a href="./products">Products</a>
                    <LogoutButton className="out" value={this.props.value}/>
                    <CartButton className="cart" value ={this.props.value}/>
                </div>
            )
        } else if(this.props.value.id === 0){
            console.log(this.props.value.id)
            return (
                <div className={className}>
                    <a href="./home">Home</a>
                     <a href="./orders">Orders</a>
                     <a href="./products">Products</a>
                    <LoginButton className="login" value={this.props.value}/>
                    <RegisterButton className="regist" value ={this.props.value}/>
                </div>
            );
        }

    }
}