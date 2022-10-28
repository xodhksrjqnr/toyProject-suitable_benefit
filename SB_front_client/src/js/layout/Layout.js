import Header from "./Header";
import Footer from "./Footer";

import 'bootstrap/dist/css/bootstrap.min.css';
import {useRef, useState} from "react";
import Scroll from "../content/Scroll";
import PostPage from "../content/PostPage";
import Filter from "../content/Filter";


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

    const filterClickEvent = () => {
        setPage("filterPage");
    }

    const changeBit = (bit) => {
        userBit.current = bit;
        setPage("mainPage");
    }

    const pageList = {
        mainPage : <Scroll userBit={userBit} clickEvent={postClickEvent}/>,
        postPage : <PostPage userBit={userBit.current} postNum={postNum.current}/>,
        filterPage : <Filter userBit={userBit} bitEvent={changeBit}/>
    }

    return (
        <div className="layout">
            <div style={{height:"10vh"}}>
                <Header clickEvent={logoClickEvent} filterClickEvent={filterClickEvent}/>
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