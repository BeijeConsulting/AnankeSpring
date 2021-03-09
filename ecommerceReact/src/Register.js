import React, { Component } from "react";
import {userContext} from './userContext.js';
import './Login.css';

export default class Register extends React.Component {


  render() {
    const showHideClassName = this.props.show ? "modal display-block" : "modal display-none";

    return (
      <div className={showHideClassName}>
        
        <div className="formdiv">
            <span className="close" onClick={this.props.handleClose}>&times;</span>
            <div>
              <form onSubmit={this.props.loginUser}>
              <div className="inputdiv">
                  <input className="inputType" type="text" name="name" placeholder="name" 
                       onChange={this.props.postUserData} 
                      required
                  />
                </div>
                <div className="inputdiv">
                  <input className="inputType" type="text" name="surname" placeholder="surname" 
                       onChange={this.props.postUserData} 
                      required
                  />
                </div>
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
                  <button className="loginbutton" type="submit">REGISTER</button>
                </div>
              </form>
            </div>
			     
        </div>
    </div>
    );
  }
}