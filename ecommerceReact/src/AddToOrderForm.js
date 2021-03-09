import React from 'react';
import './AddToOrderForm.css';
import authContext from './userContext';
import Login from './Login.js';
//import NumericInput from 'react-native-numeric-input';

export default class AddToOrderForm extends React.Component {
    constructor() {
        super();
        this.state = {
          show: false,
          //productNumber: 0
        };
        this.showModal = this.showModal.bind(this);
        this.hideModal = this.hideModal.bind(this);
        /*this.updateProductNumber = this.updateProductNumber.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.submit = this.submit.bind(this);*/
      }
    
      showModal = () => {
        this.setState({ show: true });
      };
    
      hideModal = () => {
        this.setState({ show: false });
      };

      /*updateProductNumber(event) {
        const p = event.target.value;
        this.setState({
          productNumber: p
        });
        console.log('state', this.state.productNumber);
      }

      handleClick(event) {
        console.log('hai cliccato submit');
        console.log('nel submit ho n. cose ', this.state.productNumber);
        
      }

      submit(event) {
        alert('stai acquistando ');
        this.addToCart();
      }

      addToCart() {
        const url = 'http://localhost:8080/AnankeSpring/api/addToCart';
        fetch(url, {
          method: 'POST',
          body: JSON.stringify({
            productId: this.props.item, //è il product ide, arriva dalle props
            quantity: this.state.productNumber
          }
          ),
          headers: {
            "Content-type": "application/json; charset=UTF-8"
          }
        })
        .then(response => response.json())
        .then(json => console.log(json));
      }*/

      //http://localhost:8080/AnankeSpring/api/addToCart/userId/productId
    //onclick -> fa una post e manda i dati a *modifica ordine* perchè aggiungo delle cose all'ordine
    //aggiunge un order item all'ordine
    render() {
        // className e id prendono il nome del prodotto e il suo id dal database
        const numberType = "number";
        const id = "quantity";
        const min = "0";
        const submitType = "submit";
        console.log('all interno dell addtoorderform lo user è', this.props.value);
        if (this.props.value != null && this.props.value != undefined && this.props.value.id !== 0) {
          return(
            <div>
              <form onSubmit={this.submit}>
                <div className="quantity buttons_added">
                  <input type="number" step="1" min="1"  max="10" name="quantity"
                    title="Qty" className="input-text qty text" size="4" pattern=""
                    onChange={this.updateProductNumber}/>
                </div>
            
                <button className = {submitType} onClick={this.handleClick}>
                  <img className = "chartButton" src="https://cdn.icon-icons.com/icons2/606/PNG/128/shopping-cart-add-button_icon-icons.com_56132.png"/>
                </button>
              </form> 
            </div>
          );
        } else {
        return (
            <div>
                <div className="quantity buttons_added">
                    <input type="number" step="1" min="1" max="10" name="quantity"
                        title="Qty" className="input-text qty text" size="4" pattern="" />
                </div>
                
                <button className = {submitType} onClick={this.addToCart}>
                    <img className = "chartButton" src="https://cdn.icon-icons.com/icons2/606/PNG/128/shopping-cart-add-button_icon-icons.com_56132.png"/>
                </button>
                <Login show={this.state.show} handleClose={this.hideModal} value = {this.props.value}>
                        <p>Modal</p>
                </Login>
            </div>
        );
        }
    }
}

//
