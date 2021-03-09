import React from 'react';
import App from './App';
import NavBar from './NavBar';

class AppContainer extends React.Component {

    constructor(props) {
      super(props);
      this.state = { 
          loggedIn: false
      }
    }

    handleLog = (boolean) => {
      this.setState({ loggedIn : boolean })
    }
  
    render() {

      return(
        <div>
          <NavBar handleLog = {this.handleLog}
            loggedIn = {this.loggedIn}
          />
          <App handleLog = {this.handleLog}
            loggedIn = {this.loggedIn} 
          />
        </div>
      )
    }
} 

export default AppContainer;