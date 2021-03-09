import React from "react";
import Product from "./Product";
import Button from "./Button";
import "./ProductPanel.css"

class ProductPanel extends React.Component{

    handleClick = (buttonName, iden) => {
        this.props.clickHandler(buttonName, iden);
      };

    render() {
        console.log(this.props.products);
        const final = this.props.products.map(product => <li className="li-product li-left" key={product.id}>
                <div className="showSingleProduct">
                    <Product image={product.image} name={product.name}/>
                    <br/>
                    <Button name="Details" clickHandler={this.handleClick} iden={product.id}/>
                </div>
            </li>);
        
        return(
            <ul className="ul-products">{final}</ul>
        )
    }
}

export default ProductPanel;