import React from 'react';
import AddToOrderForm from './AddToOrderForm';
import Product from './Product';
import './ProductContainer.css';

export default class ProductContainer extends React.Component {
    /*constructor(props) {
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

         fetch("http://localhost:8080/AnankeSpring/api/products")
            .then(res => {
                res.json();
                console.log(res);
            })
            .then(json => console.log(json))
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        products: result.products
                    });
                    console.log(this.state.products);
                },
                // Note: it's important to handle errors here
                // instead of a catch() block so that we don't swallow
                // exceptions from actual bugs in components.
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )*/
    

    render() {
        /*  ATTENZIONE: se non c'è un utente loggato la parte di aggiungere all'ordine non deve esserci
            poi lavoriamo con l'utente in sessione per capire come deve essere fatto
        */
        //const { error, isLoaded, products } = this.state;
        /*if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Loading...</div>;
        } else {*/
            const className = "ProductContainer";
            const productsView = this.props.products.map((product) => 
                <div className={className}>
                    <Product key={product.id} id={product.id} className={product.name}
                        name={product.name} price={product.price}>
                    </Product>
                    <AddToOrderForm value = {this.props.value} key={product.name} item={product.id} price={product.price}/>
                </div>
            );
            return (
                <div className="ProductTable">
                    {productsView}
                </div>
                
            );
        /*}*/
    }
}