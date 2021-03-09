import React, { Component } from "react";
import Item from './Item.js';
import './Login.css';

export default class Cart extends React.Component {

    render() {
        const showHideClassName = this.props.show ? "modal display-block" : "modal display-none";
        const productsView = this.props.products.map((product) => 
        <div className='item'>
            <Item key={product.id} id={product.id}
                orderId={product.orderId} productId={product.productId} quantity={product.quantity} amount={product.amount}>
            </Item>
        </div>
    );
        return (
        <div className={showHideClassName}>
            
            <span className="close" onClick={this.props.handleClose}>&times;</span>
            <div className="formdiv">
                {productsView}
                    
            </div>
        </div>
        );
    }
}