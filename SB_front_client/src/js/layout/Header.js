import {Col, Container, Row} from "react-bootstrap";

function Header() {
    return (
        <Container style={{
            backgroundColor:"#0093FE",
            color:"white",
            fontSize:"30px",
            verticalAlign: "middle"
        }}>
            <Row>
                <Col sm={9}>
                    <em><b><strong>Suitable Benefit</strong></b></em>
                </Col>
                <Col sm={3}>
                    <button>test</button>
                </Col>
            </Row>
        </Container>
    );
}

export default Header;