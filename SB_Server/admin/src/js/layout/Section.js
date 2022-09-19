import React from "react";
import Col from "react-bootstrap/Col";

import '../../css/Section.css'

function Section(props) {
    return (
        <Col sm={10} className="section h-100">
            {props.page}
        </Col>
    );
}

export default Section;