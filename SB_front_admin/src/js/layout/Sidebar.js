import React, {useState} from "react";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

import '../../css/Sidebar.css'

import Dashboard from "../content/Dashboard";
import UploadForm from "../content/UploadForm";
import Section from "./Section";

function Sidebar() {
    const [content, setContent] = useState("dashboard");

    const handleClickEvent = e => {
        const {name} = e.target;
        setContent(name)
    };

    const sidebarList = {
        dashboard : <Dashboard/>,
        uploadForm : <UploadForm/>
    };

    return (
        <Row className="sidebar">
            <Col sm={2}>
                <Row className="mt-4">
                    <a href="http://localhost:3000" target="_blank" rel="noopener noreferrer">사이트 바로가기</a>
                </Row>
                <Row className="mt-4">
                    <p>사이트 관리------</p>
                    <button onClick={handleClickEvent} name="dashboard">대시보드</button>
                    <button onClick={handleClickEvent} name="uploadForm">게시물 등록</button>
                </Row>
            </Col>
            <Section page={sidebarList[content]}/>
        </Row>
    );
}

export default Sidebar;