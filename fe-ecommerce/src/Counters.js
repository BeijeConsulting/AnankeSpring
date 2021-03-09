import React, { Component } from "react";
import Counter from "./Counter";

class Counters extends Component {
  render() {
    const {
      onReset,
      onIncrement,
      onDelete,
      onDecrement,
      counters,
      onRestart
    } = this.props;
    return (
      <div>
        {counters.map(counter => (
          <Counter
            key={counter.id}
            name={counter.name}
            counter={counter}
            onIncrement={onIncrement}
            onDecrement={onDecrement}
            onDelete={onDelete}
          />
        ))}
      </div>
    );
  }
}

export default Counters;