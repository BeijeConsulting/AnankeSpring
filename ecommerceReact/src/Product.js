import React from 'react';
import './Product.css';

export default class Product extends React.Component {
    render() {
        // className e id prendono il nome del prodotto e il suo id dal database
        const className = "Product";
        return (
            <div className = {className} id= {this.props.id}>
                <h3 className = "name">{this.props.name}</h3>
                <img  className = "image" src="https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-12-pro-family-hero?wid=470&amp;hei=556&amp;fmt=jpeg&amp;qlt=95&amp;op_usm=0.5,0.5&amp;.v=1604021663000"/> 
                <h3 className = "price">$ {this.props.price}</h3>
            </div>
            
        );
    }
}

//"https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-12-pro-family-hero?wid=470&amp;hei=556&amp;fmt=jpeg&amp;qlt=95&amp;op_usm=0.5,0.5&amp;.v=1604021663000"/