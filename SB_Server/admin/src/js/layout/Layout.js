import Container from 'react-bootstrap/Container';
import React from "react";

import 'bootstrap/dist/css/bootstrap.min.css';

import Header from './Header'
import Sidebar from "./Sidebar";


function Layout() {
    return (
        <Container fluid className="vh-100">
            <Header/>
            <Sidebar/>
        </Container>
    );
}

export default Layout;