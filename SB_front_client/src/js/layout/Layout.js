import Header from "./Header";
import Footer from "./Footer";

import 'bootstrap/dist/css/bootstrap.min.css';
import {useRef, useState} from "react";
import Scroll from "../content/Scroll";
import PostPage from "../content/PostPage";


function Layout() {
    const [page, setPage] = useState("mainPage")
    const userBit = 1630063798920911600;
    const postNum = useRef(0);

    const logoClickEvent = () => {
        setPage("mainPage");
    }

    const postClickEvent = (id) => {
        postNum.current = id;
        setPage("postPage");
    }

    const pageList = {
        mainPage : <Scroll userBit={userBit} clickEvent={postClickEvent}/>,
        postPage : <PostPage userBit={userBit} postNum={postNum.current}/>
    }

    return (
        <div className="layout">
            <div style={{height:"10vh"}}>
                <Header clickEvent={logoClickEvent}/>
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