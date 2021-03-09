import React from "react";
import "./Order.css";

class Order extends React.Component {

    render() {
        console.log("stato" + this.props.state);
        return(      
				<tr>			
					<td>{this.props.id}</td>
	    			<td>{this.props.state}</td>
					<td>{this.props.amount}</td>
				</tr>       
        );
    }
}

export default Order;