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
        <Container fluid className="vh-100">
            <Row className="h-100">
                <Col sm={2} className="Side">
                    <Side/>
                </Col>
                <Col sm={10} className="Main">
                    <Row className="bg-light"><Header/></Row>
                    <Row className="bg-light m-3"><Content/></Row>
                </Col>
            </Row>
        </Container>
    );
}

export default Layout;