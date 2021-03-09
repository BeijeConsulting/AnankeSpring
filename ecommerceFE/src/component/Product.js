import React from "react";
import "./Product.css";
class Product extends React.Component {

    render() {
        return(
        <div className="product">
            <img className="productImg" src={this.props.image}/><br/>
            <p>{this.props.name}</p><br/>
        </div>
        );
    }
}

export default Product;