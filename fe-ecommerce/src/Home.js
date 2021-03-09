import Registration from './Registration';
import NavBar from './NavBar';
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { BrowserRouter, Route } from "react-router-dom";
import Row from 'react-bootstrap/Row';
import Container from 'react-bootstrap/Container';
import Col from 'react-bootstrap/Col';
import Jumbotron from 'react-bootstrap/Jumbotron';

function Home() {
    return (
        
        <Container fluid>
            
            <Jumbotron fluid>
                <Container>
                 <h1>Fluid jumbotron</h1>
                     <p>
                    This is a modified jumbotron that occupies the entire horizontal space of
                    its parent.
                </p>

                </Container>
            </Jumbotron>
        
        <Container fluid>
         <Row>
            <Col>
                <Card style={{ width: '20rem' }}>
                    <Card.Img variant="top" src="holder.js/100px180" />
                        <Card.Body>
                        <Card.Title>Card Title</Card.Title>
                    <Card.Text>
                            Some quick example text to build on the card title and make up the bulk of
                            the card's content.
                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                    </Card.Body>
                </Card>
            </Col>

             <Col>
                    <Card style={{ width: '20rem' }}>
                    <Card.Img variant="top" src="holder.js/100px180" />
                    <Card.Body>
                    <Card.Title>Card Title</Card.Title>
                    <Card.Text>
                        Some quick example text to build on the card title and make up the bulk of
                        the card's content.
                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                    </Card.Body>
                </Card>
            </Col>

            <Col>
         
                <Card style={{ width: '20rem' }}>
                    <Card.Img variant="top" src="holder.js/100px180" />
                    <Card.Body>
                    <Card.Title>Card Title</Card.Title>
                    <Card.Text>
                        Some quick example text to build on the card title and make up the bulk of
                        the card's content.
                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                    </Card.Body>
                </Card>

            </Col>

            <Col>
         
                <Card style={{ width: '20rem' }}>
                    <Card.Img variant="top" src="holder.js/100px180" />
                    <Card.Body>
                    <Card.Title>Card Title</Card.Title>
                    <Card.Text>
                        Some quick example text to build on the card title and make up the bulk of
                        the card's content.
                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                    </Card.Body>
                </Card>

            </Col>
       </Row>
       </Container>

    </Container>

    )}

export default Home;