import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

import Side from './Side'
import Header from './Header'
import Content from './Content'

import '../../css/Layout.css'

function Layout() {
    return (
        <Container fluid>
            <Row>
                <Col sm={3} className="Side">
                    <Row className="logo"><p>Logo</p></Row>
                    <Row><Side/></Row>
                </Col>
                <Col sm={7}>
                    <Row md={5}><Header/></Row>
                    <Row md={5}><Content/></Row>
                </Col>
            </Row>
        </Container>
    );
}

export default Layout;