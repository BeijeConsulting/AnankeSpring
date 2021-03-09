import React from 'react';
import ReactDOM from 'react-dom';
import Register from './Register.js';
import './Navbar.css';


export default class RegiterButton extends React.Component {
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
                    <button onClick={this.showModal}>Register
                    </button>
                    
                </div>
                <Register show={this.state.show} handleClose={this.hideModal} value = {this.props.value}>
                    <p>Modal</p>
                </Register> 
            </div>
                
            
        );
    }
}
