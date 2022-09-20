import React from "react";
import Col from "react-bootstrap/Col";

function Section(props) {
    return (
        <Col sm={10} style={{backgroundColor:"#d2d2d2", color:"black"}}>
            {props.page}
        </Col>
    );
}

export default Section;