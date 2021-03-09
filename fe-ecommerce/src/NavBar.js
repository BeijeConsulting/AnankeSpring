import React from 'react';
import { BrowserRouter, Route } from "react-router-dom";

class NavBar extends React.Component{

    
    constructor(props){
        
        super(props)

    }
    
    logout() {

        localStorage.removeItem("user");

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        };
    
        return fetch(`http://localhost:8080/AnankeSpring/api/ecommerce/logOut}`, requestOptions);

    }
    
    render(){
    
        return (

            <div>

                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">

                    <div className="container-fluid">

                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    {(!this.props.loggedIn) ? (
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="./home">Home</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="./products">Catalogo Prodotti</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="./orders">I miei Ordini</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link active" onClick={() => this.Logout()} aria-current="page" href="./">Logout</a>
                            </li>
                        </ul>

                    </div>
                    )
                    :
                    <div style = { {
                        color : "white"
                    }}>
                        Benvenuto!
                    </div>
                    }
                </div>

                </nav>

            </div>

        )
    }
    

}

export default NavBar;