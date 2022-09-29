import Container from 'react-bootstrap/Container';
import React from "react";

import 'bootstrap/dist/css/bootstrap.min.css';

import Header from './Header'
import Sidebar from "./Sidebar";


function Layout() {
    return (
        <Container fluid>
            <Header/>
            <Sidebar/>
        </Container>
    );
}

export default Layout;