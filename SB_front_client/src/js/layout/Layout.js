import {Container, Row} from "react-bootstrap";
import Header from "./Header";
import Footer from "./Footer";
import Section from "./Section";

import 'bootstrap/dist/css/bootstrap.min.css';
import {useRef, useState} from "react";
import Scroll from "../content/Scroll";
import PostPage from "../content/PostPage";

function Layout() {
    const [page, setPage] = useState("mainPage")
    const userBit = 1630063798920911600;
    const postNum = useRef(0);

    const postClickEvent = (id) => {
        postNum.current = id;
        setPage("postPage");
    }

    const pageList = {
        mainPage : <Scroll userBit={userBit} clickEvent={postClickEvent}/>,
        postPage : <PostPage userBit={userBit} postNum={postNum.current}/>
    }

    return (
        <Container fluid className="vh-100">
            <Row style={{height:"10vh"}}>
                <Header/>
            </Row>
            <Row style={{height:"80vh"}}>
                <Section page={pageList[page]}/>
            </Row>
            <Row style={{height:"10vh"}}>
                <Footer/>
            </Row>
        </Container>
    );
}

export default Layout;