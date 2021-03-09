import React from "react";
import "./Button.css";

export default class Button extends React.Component {

  handleClick = () => {
    this.props.clickHandler(this.props.name, this.props.iden);
  };

  render() {
    return (
      <div >
        <button className="btn btn-primary btn-block btn-large" onClick={this.handleClick}>{this.props.name}</button>
      </div>
    );
  }
}
