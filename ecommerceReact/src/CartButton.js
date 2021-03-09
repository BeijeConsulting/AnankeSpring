import React from 'react';
import ReactDOM from 'react-dom';
import './Navbar.css';
import CartTable from './CartTable.js';

export default class CartButton extends React.Component {
    constructor() {
        super();
        this.state = {
            show: false,
        };
        this.showModal = this.showModal.bind(this);
        this.hideModal = this.hideModal.bind(this);
    }

    showModal = () => {
        this.setState({ show: true });
    };

    hideModal = () => {
        this.setState({ show: false });
    };

    render() {
        return (
            <div>
                <div>
                    <button onClick={this.showModal}>Cart
                    </button>
                    
                </div>
                <CartTable show={this.state.show} handleClose={this.hideModal} value = {this.props.value}>
                    <p>Modal</p>
                </CartTable> 
            </div>
                
            
        );
    }
}
