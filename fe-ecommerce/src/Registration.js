import Login from './Login';
import { BrowserRouter, Route } from "react-router-dom";
import { useHistory } from "react-router"

function Registration() {
    return (
        <div>

        <BrowserRouter>
			  <div>
				  <Route exact path="/" component={Login}/>
			  </div>
		</BrowserRouter>
        
        <div className="row">

            <div className="text-center col-md-6 offset-md-3">

                <h1>E - COMMERCE</h1>
                <h2>Registrazione</h2>
            </div>

            <div className="text-center col-md-6 offset-md-3">

                <div className="form-group">
                    <label htmlFor="email">Email</label>
  		            <input className="form-control" type="text" id="email" name="email" required/>
                </div>
                <div className="form-group">
                    <label htmlFor="email">Nome</label>
  		            <input className="form-control" type="text" id="nome" name="nome" required/>
                </div>
                <div className="form-group">
                    <label htmlFor="email">Cognome</label>
  		            <input className="form-control" type="text" id="cognome" name="cognome" required/>
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
  		            <input className="form-control" type="password" placeholder="Enter Password" id="password" name="password" required/>
                </div>
            
  		    <input type="button" className="btn btn-primary" value="REGISTRATI" onClick = {registration} />

            </div>

            <div className="col-md-6 offset-md-3">
             <a href= "/" >Hai già un account? Fai il login</a>
            </div>

        </div>
    </div>
    );
}

function registration() {
    
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('nome').value;
    let secondName = document.getElementById('cognome').value;

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password, firstName, secondName})
    };

    return fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/registration`, requestOptions)
        .then(handleResponse)
        .then(user => {
            // login successful if there's a user in the response
            if (user) {
                // store user details and basic auth credentials in local storage 
                // to keep user logged in between page refreshes
                // user.authdata = window.btoa(email + ':' + password);
                //localStorage.setItem('user', JSON.stringify(user));
                console.log(user);
                //this.props.history.push('/');
            }

            return user;
        });
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

// "http://localhost:8080/AnankeSpring/ecommerce/homePage"

export default Registration;