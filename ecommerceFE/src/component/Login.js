import React from "react";
import "./Login.css";
import Register from "./Register";
import Home from "./Home";

class Login extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      email:null,
      password:null,   
      isLoggedIn: false,
      register: false,
      userId: null,
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }


  handleSubmit(event) {
    event.preventDefault();
    fetch('http://localhost:8080/AnankeSpring/api/login', {
		method: 'POST',
		body: JSON.stringify({
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
        alert("Authentication failed!");
      }else{
        let id = json.id;
        this.setState({userId: id});
        this.setState({isLoggedIn:true});
      }
    })
    
  }

  handleClick = () => {
    this.setState({register: true});
  };

  handleChange = (event) => {
    let name = event.target.name;
    let value = event.target.value
    this.setState({[name]: value});
    
  };

  render() {
    if(!this.state.register && !this.state.isLoggedIn){
    return(
      
    <div className="login">
  			<h1>Login</h1>
        <form onSubmit={this.handleSubmit}>
 			 
    			<input type="text" placeholder="Email" name="email" onChange={this.handleChange}/>
    			<input type="password" placeholder="Password" name="password"  onChange={this.handleChange} />
    			<button type="submit" className="btn btn-primary btn-block btn-large" iden={null}>Login</button> <br/>
   				<button className="btn btn-primary btn-block btn-large" onClick={this.handleClick} iden={null}>Register</button>
   			 </form>
	</div>
  
    );
    }else if(this.state.register){
      return(
        <Register/>
      );
    }else{
      return(
        <Home user={this.state.userId}/>
      );
    }
  }
}
export default Login;