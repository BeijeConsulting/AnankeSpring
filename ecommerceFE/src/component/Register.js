import React from "react";
import "./Register.css";
import Login from "./Login";
import Button from "./Button";
import movement from "../logic/movement";

class Register extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
          name: '',
          surname: '',
          email: '',
          password: '',
          login: false,
        };

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        if(this.state.email == "" || this.state.password == ""){
            alert("Email and password cannot be empty!");
        }else{
        fetch('http://localhost:8080/AnankeSpring/api/register', {
		method: 'POST',
		body: JSON.stringify({
            name:this.state.name,
            surname:this.state.surname,
            email:this.state.email,
		    password: this.state.password,
		}),
		headers: {
		  "Content-type": "application/json; charset=UTF-8"
		}
	  })
	  .then(response => response.json())
	  .then(json => {
        console.log(json);
        if(json.id === null){
            alert("Email address already registered! Click on Back to login")
        }else{
            this.setState({login: true});
            alert("You were successfully registered! Please Login.");
        }
    })
        
    }
    }

    myChangeHandler = (event) => {
        let nam = event.target.name;
        let val = event.target.value;
        this.setState({[nam]: val});
      }
    
    handleClick = (buttonName, iden) => {
        this.setState(movement(this.state, buttonName, iden));
    };

    render(){
        if(!this.state.login){
        return(
            
            <div className="Register">
                <h1>Register</h1>
                <form onSubmit={this.handleSubmit}>
                    <input 
                        type="text" 
                        name="name" 
                        placeholder="Name"
                        onChange={this.myChangeHandler}/>
                        <br/> 
                    <input
                        type="text" 
                        name="surname" 
                        placeholder="Surname"
                        onChange={this.myChangeHandler}/>
                        <br/>
                    <input 
                        type="text" 
                        name="email" 
                        placeholder="Email"
                        onChange={this.myChangeHandler}/>
                        <br/>
                    <input 
                        type="text" 
                        name="password" 
                        placeholder="Password"
                        onChange={this.myChangeHandler}/>
                        <br/>
                    <br/>
                    <Button name="Register" type="submit" clickHandler={this.handleClick} iden={null}/>
                    <Button name="Back" clickHandler={this.handleClick} iden={null}/>
                </form>
            </div>
        );
        }else{
            return(
                <Login/>
            );
        }
    }
}

export default Register;
