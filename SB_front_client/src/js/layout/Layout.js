import Header from "./Header";
import Footer from "./Footer";

import 'bootstrap/dist/css/bootstrap.min.css';
import {useRef, useState} from "react";
import Scroll from "../content/Scroll";
import PostPage from "../content/PostPage";


function Layout() {
    const [page, setPage] = useState("mainPage")
    const userBit = useRef(0);
    const postNum = useRef(0);

    const logoClickEvent = () => {
        setPage("mainPage");
    }

    const postClickEvent = (id) => {
        postNum.current = id;
        setPage("postPage");
    }

    const changeBit = (bit) => {
        userBit.current = bit;
    }

    const pageList = {
        mainPage : <Scroll userBit={userBit} clickEvent={postClickEvent}/>,
        postPage : <PostPage userBit={userBit.current} postNum={postNum.current}/>
    }

    return (
        <div className="layout">
            <div style={{height:"10vh"}}>
                <Header userBit={userBit} clickEvent={logoClickEvent} bitEvent={changeBit}/>
            </div>
            <div style={{height:"80vh"}}>
                {pageList[page]}
            </div>
            <div style={{height:"10vh"}}>
                <Footer/>
            </div>
        </div>
    );
}

export default Layout;