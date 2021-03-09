import React, { Component } from "react";

class Counter extends Component {
  render() {
    return (
      <div>
        <div className="row">

          <div /*className="col-md-1"*/>
            <span style={{ fontSize: 24 }} className={this.getBadgeClasses()}>
              {this.props.counter.value}
            </span>
          </div>
          <div /*className="col-md-4"*/>
            <button
              className="btn btn-secondary"
              onClick={() => this.props.onIncrement(this.props.counter)}
            >+
              <i className="fa fa-plus-circle" aria-hidden="true" />
            </button>
            <button
              className="btn btn-info m-2"
              onClick={() => this.props.onDecrement(this.props.counter)}
              disabled={this.props.counter.value === 0 ? "disabled" : ""}
            >-
              <i className="fa fa-minus-circle" aria-hidden="true" />
            </button>
            <button
              className="btn btn-primary"
              onClick={() => this.props.addToCart(this.props.counter)}
            >Add
              <i className="fa fa-trash-o" aria-hidden="true" />
            </button>
          </div>
        </div>
      </div>
    );
  }

  getBadgeClasses = () => {
    let classes = "badge m-2 badge-";
    classes += this.props.counter.value === 0 ? "warning" : "primary";
    return classes;
  };

  formatCount = () => {
    const { value } = this.props.counter.value;
    console.log(this.props.counter.value)
    return value === 0 ? 0 : value;
  };
}

export default Counter;
/*
<div className="col-md-1" style={{
            color: "#ffcc00",
            backgroundColor: "#3d0066",
            borderRadius : "10px",
            textAlign: "center",
            font : "italic bold 20px arial,serif",
            paddingTop : "16px",
            textShadow : "0px 5px 1px #997a00"}}>
            {this.props.name}
          </div>
          */