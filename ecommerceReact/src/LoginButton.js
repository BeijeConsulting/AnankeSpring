import React from 'react';
import ReactDOM from 'react-dom';
import './Navbar.css';
import Login from './Login.js';

export default class LoginButton extends React.Component {
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
                    <button onClick={this.showModal}>Login
                    </button>
                    
                </div>
                <Login show={this.state.show} handleClose={this.hideModal} value = {this.props.value}>
                    <p>Modal</p>
                </Login> 
            </div>
                
            
        );
    }
}
