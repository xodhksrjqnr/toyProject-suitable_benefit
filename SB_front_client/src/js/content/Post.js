import {Col, Container, Row} from "react-bootstrap";
import {useEffect, useState} from "react";

import '../../css/Post.css'

function Post(props) {
    const [percent, setPercent] = useState("");
    const [day, setDay] = useState("");

    useEffect(() => {
        const validBit = ((props.info.needConditions & props.userBit) >>> 0).toString(2);
        const bit = (props.info.needConditions >>> 0).toString(2);
        const denominator = bit.replaceAll("0", "").length;
        const numerator = validBit.replaceAll("0", "").length;
        setPercent(Math.round((numerator / denominator) * 100) + "%");
        setDay("D - " + Math.floor((new Date(props.info.expirationDate) - Date.now()) / (1000 * 60 * 60 * 24)));
    }, [])

    return (
        <div className="shadow post">
            <div className="imgBox">
                <img src={props.info.imgPath} alt="postImg" className="img-fluid"/>
            </div>
            <div className="infoBox">
                <div className="title">
                    {props.info.title}
                </div>
                <div className="content">
                    <Row>
                        <Col className="day">{day}</Col>
                        <Col className="fitness">
                            <div className="rounded-5 h-100" style={{backgroundColor:"#7AF67A"}}>
                                {percent}
                            </div>
                        </Col>
                    </Row>
                </div>
                <div className="tag"></div>
            </div>
        </div>
    );
}

export default Post;