import React from "react";
import "./MyOrders.css";
import Order from "./Order";

export default class MyOrders extends React.Component{
    render(){
        console.log(this.props.orders);
        const final = this.props.orders.map(order =>
           
            <Order key={order.id} id={order.id} state={order.state} amount={order.amount}/>

        );
        
        return(
            <div>
            <h3>Orders</h3>
            <table id="orders">
                <tr>
			        <th>Order</th>
			        <th>State</th>
			        <th>Amount</th>
                </tr>
                    {final}
            </table>
            </div>
        )
    }

    componentDidMount(){
        fetch('http://localhost:8080/AnankeSpring/api/orders?id=2')
        .then(response => response.json())
        .then(json => {
            console.log(json);
            this.setState({orders: json});
        });
    }
}