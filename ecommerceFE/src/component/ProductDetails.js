import React from "react";
import Button from "./Button";
import Product from "./Product";

export default class ProductDetails extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            goBack: false,
            qnt: null,
        }
    }

    handleSubmit(event){
        event.preventDefault();
        fetch('http://localhost:8080/AnankeSpring/api/product-details', {
		method: 'PUT',
		body: JSON.stringify({
            userId: this.props.userId,
            orderId: null,
            id:this.props.showing.id,
            qnt: this.state.qnt,
		}),
		headers: {
		  "Content-type": "application/json; charset=UTF-8"
		}
	  })
	  .then(response => response.json())
	  .then(json => {
            console.log(json);
            
        })
    }

    handleChange = (event) => {
        this.setState({qnt: event.target.value});
        
      };


    render(){
        return(
            <div>
                <Product image={this.props.showing.image} name={this.props.showing.name}/>
                <div>
                <ul>
                    <li>{this.props.showing.desc}</li>
                    <li>{this.props.showing.price}</li>
                </ul>
                </div>
                <div>
                    <form action="" method="post">
                    <input 
                        type="text"
                        name="quantity"
                        placeholder="Quantity" 
                        onChange={this.handleChange}
                        />
                    <Button name="Add" type="submit" clickHandler={this.handleClick} iden={null}/>
                    <br/>
                    <Button name="Back to Shopping" clickHandler={this.handleClick} iden={null}/>
                    <br/>
                    <Button name="Buy" clickHandler={this.handleClick} iden={null}/>
                    </form>    
                </div>
            </div>
            
        );
    }
}