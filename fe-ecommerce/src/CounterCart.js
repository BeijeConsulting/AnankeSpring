import React, { Component } from "react";

class CounterCart extends Component {
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
              className="btn btn-danger"
              onClick={() => this.props.onDelete(this.props.counter.id)}
            >Remove
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

export default CounterCart;