import Cart from './Cart';
import Counters from './Counters';
import Counter from './Counter';
import React from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCoffee } from '@fortawesome/free-solid-svg-icons'

class Products extends React.Component {

    constructor(props) {
        super(props);
        this.state = { 
            products: [],
            counters: []
        }

        const element = <FontAwesomeIcon icon={faCoffee} />
    }
    
    addToCart = counter => {
        const counters = [...this.state.counters];
        const index = counters.indexOf(counter);
        counters[index] = { ...counters[index] };

        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' }
        };
    
        return fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/addProduct/${counters[index].id}/${counters[index].value}`, requestOptions);

    }

    handleIncrement = counter => {
        const counters = [...this.state.counters];
        const index = counters.indexOf(counter);
        counters[index] = { ...counters[index] };
        counters[index].value++;
        this.setState({ counters });
        //console.log(counters[index].value)
      };
    
    handleDecrement = counter => {
    const counters = [...this.state.counters];
    const index = counters.indexOf(counter);
    counters[index] = { ...counters[index] };
    counters[index].value--;
    this.setState({ counters });
    //console.log(counters[index].value)
    };

    handleDelete = counter => {
        const counters = [...this.state.counters];
        const index = counters.indexOf(counter);
        counters[index] = { ...counters[index] };
        counters[index].value = 0;
    this.setState({ counters });
    };

    componentDidMount() {

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        };
        
        let array = []

        fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/getProduct`, requestOptions)
          .then(response => response.json())
          .then(data => {
            this.setState({ products: data })
            this.state.products.forEach(product => {
            array.push({
                id: product.id,
                name: product.name,
                value: 0
            })

            this.setState({ counters : array })
            
            })
          })

        }

    render() {
        return (
            
            <Container>
                
            <Cart
                totalCounters={this.state.counters.reduce(function (t,c){
                return t+c.value;
                }, 0)}/>
            <div className="row">

                <div className="text-center col-md-6 offset-md-3">

                    <h1>E - COMMERCE</h1>
                    <h2>Prodotti</h2>

                </div>
            </div>

            <Container fluid>
                 <Row>

                {this.state.products.map(product => {
                return <div key={`product-${product.id}`}>

                <Col>
                    <Card style={{ width: '15rem'}}>
                        
                            <Card.Body>
                            <Card.Title>{product.name}</Card.Title>
                        <Card.Text>
                                {product.desc}
                        </Card.Text>
                        <Card.Text>
                                {product.price} €
                        </Card.Text>
                        {this.state.counters.filter(counter => counter.id === product.id).map(counter => (
                            <Counter
                                key={counter.id}
                                name={counter.name}
                                counter={counter}
                                onIncrement={this.handleIncrement}
                                onDecrement={this.handleDecrement}
                                onDelete={this.handleDelete}
                                addToCart={this.addToCart}
                            />
                        ))}
                        </Card.Body>
                    </Card>
                </Col>
                </div>
                 })}

                </Row>
            </Container>

        </Container>
        );
    }
}

/*
{this.state.products.map(product => {
    return <li key={`movie-${product.id}`}>{product.name}</li>
     })}
*/

// "http://localhost:8080/AnankeSpring/ecommerce/homePage"

export default Products;