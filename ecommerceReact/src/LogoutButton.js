import React from 'react';
import ReactDOM from 'react-dom';
import {userContext} from './userContext';
import './Navbar.css';

export default class LogoutButton extends React.Component {
    render() {
        return (
            <button onClick={this.props.logoutUser}>Logout</button> 
            
        );
    }
}
