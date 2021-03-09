import Registration from './Registration';
import Home from './Home';
import { BrowserRouter, Route } from "react-router-dom";
import { Redirect } from "react-router-dom";
import React from 'react';

class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state = { 
            loggedIn: true
        };

    }

    login() {
    
        let email = getEmail();
        let password = getPassword();
    
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password })
        };
    
        return fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/logIn`, requestOptions)
            .then(handleResponse)
            .then(user => {
                // login successful if there's a user in the response
    
                if (user) {
                    // store user details and basic auth credentials in local storage 
                    // to keep user logged in between page refreshes
                    user.authdata = window.btoa(email + ':' + password);
                    localStorage.setItem('user', JSON.stringify(user.id));
                    console.log(user);
                    
                    return(
                        <BrowserRouter>
                        <Route exact path="/">
                            {user ? <Redirect to="/home" /> : <Login/>}
                        </Route>
                        </BrowserRouter>
                    )
    
            }
    
            return (
                <Route exact path="/">
                    <Redirect to="/logIn" />
                </Route>
            )
        });
    }

    render() {

    return (
        <div>

        <BrowserRouter>
			  <div>
                <Route exact path="/registration" component={Registration}/>
                <Route exact path="/home" component={Home}/>
			  </div>
		</BrowserRouter>

        <div className="row">

            <div className="text-center col-md-6 offset-md-3">

                <h1>E - COMMERCE</h1>

            </div>

            <div className="text-center col-md-6 offset-md-3">

                <div className="form-group">
                    <label htmlFor="email">Email</label>
  		            <input className="form-control" type="text" id="email" name="email" required/>
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
  		            <input className="form-control" type="password" placeholder="Enter Password" id="password" name="password" required/>
                </div>
            
                <div>
                    <input type="button" className="btn btn-primary" value="ACCEDI" onClick = {this.login} />
                </div>
  		        
            
            </div>

            <div className="col-md-6 offset-md-3">
                 <a href= "./registration" >Non hai un account? Registrati qui</a>
            </div>

            <div className="col-md-6 offset-md-3">
                 <a href= "./home" >Home</a>
            </div>

        </div>
    </div>
    );

    }
}

// "http://localhost:8080/AnankeSpring/ecommerce/homePage"
function getEmail(){
    return document.getElementById('email').value;
}

function getPassword(){
    return document.getElementById('password').value;
}


function handleResponse(response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        /*
        if (!response.ok) {
            if (response.status === 401) {
                // auto logout if 401 response returned from api
                logout();
                location.reload(true);
            }

            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }
        */

        return data;
    });
}

export default Login;