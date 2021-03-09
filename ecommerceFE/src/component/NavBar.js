import React from "react";
import "./NavBar.css";
import Button from "./Button";
import movement from "../logic/movement";

export default class NavBar extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
        };
    }

    handleClick = (buttonName, iden) => {
      this.props.clickHandler(buttonName, iden);
      };

    render() {
        return (
            <ul className="ul-navbar">
            <li className="li-left"><Button name="Home" clickHandler={this.handleClick} iden={null}/></li>
            <li className="li-left"><Button name="My orders" clickHandler={this.handleClick} iden={null}/></li>
            <li className="li-left"><Button name="Profile" clickHandler={this.handleClick} iden={null}/></li>
            <li className="li-right"><Button name="Logout" clickHandler={this.handleClick} iden={null}/></li>
          </ul>
        );
      }
    }