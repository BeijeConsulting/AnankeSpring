import React from 'react';
import Navbar from './Navbar';
import ProductTable from './ProductTable';
import userContext from './userContext';

export default class Page extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            //user: {}
            id: 1,
            firstName: 'stefano',
            secondName: 'savallo',
            email: 'ste@beije.com',
            password: '123'
        }
        /*this.logout = this.logout.bind(this);*/
    }

    
    /*logout() {
        this.setState({
            user: '',
        })
    }*/

    /*getUserWithFetch() {
        const url = 'http://localhost:8080/AnankeSpring/api/session';
        return fetch(url).then(response => {
            console.log('response:', response);
            response.json();
        });
    }

    componentDidMount() {
        console.log('sto eseguando il mount')
        this.getUserWithFetch().then(response => {
            this.setState({
                user: response
            });
            console.log('user: ', this.response);
        });
    }*/

    render() {
        const className="Navbar";
        const value = this.state;
        console.log('page user:', value);
        
        return (
            <div>
                <Navbar value={value}/>
                <ProductTable value={value} />
            </div>
        );
               
    }
}
