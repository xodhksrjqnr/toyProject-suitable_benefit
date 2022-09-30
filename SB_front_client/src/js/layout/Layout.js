import {Container, Row} from "react-bootstrap";
import Header from "./Header";
import Footer from "./Footer";
import Section from "./Section";

import 'bootstrap/dist/css/bootstrap.min.css';

function Layout() {
    return (
        <Container fluid className="vh-100">
            <Row style={{height:"10vh"}}>
                <Header/>
            </Row>
            <Row style={{height:"80vh"}}>
                <Section/>
            </Row>
            <Row style={{height:"10vh"}}>
                <Footer/>
            </Row>
        </Container>
    );
}

export default Layout;