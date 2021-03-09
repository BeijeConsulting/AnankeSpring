import Cart from './Cart';
import Counters from './Counters';
import Counter from './Counter';
import CounterCart from './CounterCart';
import React from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

class CartItems extends React.Component {

    constructor(props) {
        super(props);
        this.state = { 
            products: [],
            counters: [],
            items: []
        }
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

    handleDelete = counterId => {
    const counters = this.state.counters.filter(c => c.id !== counterId);
    this.setState({ counters });

    const requestOptions = {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    };
    
    let array = []

    fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/removeProduct/${counterId}`, requestOptions)
          .then(response => response.json())
          .then(data => {
            this.setState({ items: data })
            this.state.items.forEach(item => {
            array.push({
                id: item.productId,
                name: item.name,
                value: item.quantity
            })

            this.setState({ counters : array })
            
            })
          })

        this.componentDidMount();

}


    componentDidMount() {

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        };

        let array = []

        fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/getOrderItems`, requestOptions)
          .then(response => response.json())
          .then(data => {
            this.setState({ items: data })
            this.state.items.forEach(item => {
            array.push({
                id: item.productId,
                name: item.name,
                value: item.quantity
            })

            this.setState({ counters : array })
            
            })
          })

        }

    confirmOrder() {

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' }
        };

        const id = localStorage.getItem('user');

        fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/openOrder/${id}`, requestOptions)

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
                    <h2>Carrello</h2>

                </div>
            </div>

            <Container fluid>

            <div className="row">

            <div className="text-center col-md-6 offset-md-3">

             <button
              className="btn btn-danger"
              onClick={() => this.confirmOrder()}
             >CONFERM ORDER
              <i className="fa fa-trash-o" aria-hidden="true" />
            </button>

            </div>
            </div>

                 <Row>

                {this.state.items.map(item => {
                return <div key={`item-${item.id}`}>

                <Col>
                    <Card style={{ width: '15rem'}}>
                        
                            <Card.Body>
                            <Card.Title>{item.productId}</Card.Title>
                        <Card.Text>
                                descrizione
                        </Card.Text>
                        <Card.Text>
                                {item.amount} €
                        </Card.Text>
                        {this.state.counters.filter(counter => counter.id === item.productId).map(counter => (
                            <CounterCart
                                key={counter.id}
                                name={counter.name}
                                counter={counter}
                                onIncrement={this.handleIncrement}
                                onDecrement={this.handleDecrement}
                                onDelete={this.handleDelete}
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

export default CartItems;