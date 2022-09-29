import {Col, Container, Row} from "react-bootstrap";
import Header from "./Header";
import Sidebar from "./Sidebar";
import Footer from "./Footer";
import Section from "./Section";

import 'bootstrap/dist/css/bootstrap.min.css';

function Layout() {
    return (
        <Container fluid>
            <Row>
                <Header/>
            </Row>
            <Row>
                <Col sm={10}><Section/></Col>
                <Col sm={2}><Sidebar/></Col>
            </Row>
            <Row>
                <Footer/>
            </Row>
        </Container>
    );
}

export default Layout;