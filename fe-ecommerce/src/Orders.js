import Login from './Login';
import { BrowserRouter, Route } from "react-router-dom";
import { useHistory } from "react-router"
import React from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

class Orders extends React.Component {

    constructor(props) {
        super(props);
        this.state = { orders: [] }
    }

    confirmOrder()  {

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' }
        };

        let user = localStorage.getItem('user');

        fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/confirmedOrder/${user}`, requestOptions)
        
        this.componentDidMount();

    }

    componentDidMount() {

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        };

        let products = [];
        let user = localStorage.getItem('user');
        console.log('user: ' + user);

        fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/myOrders/${user}`, requestOptions)
          .then(response => response.json())
          .then(data => {
            this.setState({ orders: data })
          })
      }

    render() {

    return (
        <div>

        <Container fluid>
                 <Row>

                {this.state.orders.map(order => {
                return <div key={`order-${order.id}`}>

                <Col>
                    <Card style={{ width: '15rem'}}>
                            <Card.Body>
                            <Card.Title>Ordine n°{order.id}</Card.Title>
                            <Card.Text>
                                {order.state === 'effettuato' ? (
                                    <div>totale: {order.amount} € </div>
                                ) : (
                                    <div>da pagare</div>
                                )}
                            </Card.Text>
                            <Card.Text>
                                stato: {order.state} 
                            </Card.Text>
                        
                            {order.state === 'effettuato' ? (
                                    <Button variant="primary">Vedi ordine</Button>
                                ) : (
                                    <Button onClick={() => this.confirmOrder()} variant="primary">Vai al pagamento</Button>
                                )}
                        
                        </Card.Body>
                    </Card>
                </Col>
                </div>
                 })}

                </Row>
            </Container>
       
         </div>
    );
    }
}


export default Orders;