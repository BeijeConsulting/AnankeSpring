import React from 'react';
import Cart from './Cart';

export default class CartTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
          error: null,
          isLoaded: false,
          products: []
        };
    }

    getProductsWithFetch() {
        const url = 'http://localhost:8080/AnankeSpring/api/cart';
        return fetch(url).then(response => response.json());
    }

    componentDidMount() {
        this.getProductsWithFetch().then(response => {
            console.log(response);
            this.setState({
                isLoaded: true,
                products: response
            });
            console.log('products: ',this.state.products);
        });
    }

    render() {
        
        const showHideClassName = this.props.show ? "modal display-block" : "modal display-none";
        const className="ProductTable";

        // si mappano i product container
        return (
            <Cart products={this.state.products} value={this.props.value}/> 
            
        );
    }
}