import React from 'react';
import ProductContainer from './ProductContainer';

export default class ProductTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
          error: null,
          isLoaded: false,
          products: []
        };
    }

    getProductsWithFetch() {
        const url = 'http://localhost:8080/AnankeSpring/api/products';
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
        const className="ProductTable";

        // si mappano i product container
        return (
            <ProductContainer products={this.state.products} value={this.props.value}/> 
        );
    }
}