import {Col, Container, Row} from "react-bootstrap";
import {useEffect, useState} from "react";

function Post(props) {
    const [percent, setPercent] = useState();
    const [day, setDay] = useState();

    useEffect(() => {
        const validBit = ((props.info.needConditions & props.userBit) >>> 0).toString(2);
        const bit = (props.info.needConditions >>> 0).toString(2);
        const denominator = bit.replaceAll("0", "").length;
        const numerator = validBit.replaceAll("0", "").length;
        setPercent(Math.round((numerator / denominator) * 100) + "%");
        setDay("D - " + Math.floor((new Date(props.info.expirationDate) - Date.now()) / (1000 * 60 * 60 * 24)));
    }, [props])

    return (
        <Container className="rounded-3 mx-5 p-0 shadow" style={{
            height:"55vh",
            aspectRatio:"10/16"
        }}>
            <Container className="h-50 p-0 rounded-top" style={{overflow:"hidden"}}>
                <img src={props.info.imgPath} alt="postImg" className="img-fluid"/>
            </Container>
            <Container className="h-50 py-1">
                <Container className="p-0" style={{
                    height: "5vh"
                }}>
                    {props.info.title}
                </Container>
                <Container className="p-0 text-center" style={{height:"10vh"}}>
                    <Row className="px-3 h-100">
                        <Col>{day}</Col>
                        <Col className="px-3">
                            <div className="rounded-5 h-100" style={{backgroundColor:"#7AF67A"}}>
                                {percent}
                            </div>
                        </Col>
                    </Row>
                </Container>
                <Container className="p-0" style={{height:"10vh"}}></Container>
            </Container>
        </Container>
    );
}

export default Post;