import 'bootstrap/dist/css/bootstrap.min.css';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Button from "react-bootstrap/Button";

import '../../css/Header.css'

function Header() {
    return (
        <Row className="header">
            <Col sm={2} className="p-1">Logo</Col>
            <Col sm={10} className="p-1 bg-white">
                <Row>
                    <Col>AdminName</Col>
                    <Col>
                        <Button className="btn-secondary btn-sm">로그아웃</Button>
                    </Col>
                </Row>
            </Col>
        </Row>
    );
}

export default Header;