import React from "react";
import Col from "react-bootstrap/Col";
import Container from "react-bootstrap/Container";

import '../../css/Section.css'

function Section(props) {
    return (
        <Col sm={10} className="section h-100">
            <Container className="bg-white">
                {props.page}
            </Container>
        </Col>
    );
}

export default Section;