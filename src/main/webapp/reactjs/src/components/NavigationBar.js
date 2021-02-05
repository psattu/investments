import React from  'react';
import {Navbar,Nav} from "react-bootstrap";
import {Link} from "react-router-dom";

class NavigationBar extends  React.Component{
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Link to={""} className="navbar-brand"> Investing Home </Link>
                <Nav className="mr-auto">
                    <Link to={"list"} className="nav-link"> Stock List </Link>
                    <Link to={"add"} className="nav-link"> Add Stock </Link>

                </Nav>
           </Navbar>
        );
    }
}
export default  NavigationBar;