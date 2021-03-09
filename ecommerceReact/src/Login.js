import React, { Component } from "react";
import {userContext} from './userContext.js';
import './Login.css';

export default class Login extends React.Component {
  /*constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
    }
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleEmailChange(event) {
    this.setState({email: event.target.value});
  }

  handlePasswordChange(event) {
    this.setState({password: event.target.value});
  }

  
  postUserData() {
    const url = 'http://localhost:8080/AnankeSpring/api/login'
    fetch(url, {
      method: 'POST',
      body: JSON.stringify({
        email: this.state.email,
        password: this.state.password,
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    })
    .then(response => response.json())
    .then(json => console.log(json));
  }

  handleSubmit() {
     const user = postUserData();

  }*/

  render() {
    const showHideClassName = this.props.show ? "modal display-block" : "modal display-none";

    return (
      <div className={showHideClassName}>
        
        <div className="formdiv">
            <span className="close" onClick={this.props.handleClose}>&times;</span>
            <div>
              <form onSubmit={this.props.loginUser}>
                <div className="inputdiv">
                  <input className="inputType" type="text" name="email" placeholder="email" 
                       onChange={this.props.postUserData} 
                      required
                  />
                </div>
                <div className="inputdiv">
                  <input className="inputType" type="password" name="password" placeholder="password" 
                       onChange={this.props.postUserData}
                      required
                  />
                </div>
                <div className="submitdiv">
                  <button className="loginbutton" type="submit">LOGIN</button>
                </div>
              </form>
            </div>
			     
        </div>
    </div>
    );
  }
}