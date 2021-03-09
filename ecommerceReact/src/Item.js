import React from 'react';
import './Product.css';

export default class Item extends React.Component {
    render() {
        // className e id prendono il nome del prodotto e il suo id dal database
        const className = "Product";
        return (
            <div className = {className} id= {this.props.id}>
                <h3 className = "name">{this.props.orderId}</h3>
                <h3 className = "name">{this.props.productId}</h3>
                <h3 className = "name">{this.props.quantity}</h3>
                <h3 className = "price">$ {this.props.amount}</h3>
            </div>
            
        );
    }
}