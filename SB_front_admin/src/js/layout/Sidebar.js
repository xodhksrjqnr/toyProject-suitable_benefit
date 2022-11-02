import React from "react";
import '../../css/Sidebar.css'

function Sidebar(props) {
    return (
        <div className="sidebar">
            <div>
                <a href="http://localhost:3000" target="_blank" rel="noopener noreferrer">사이트 바로가기</a>
            </div>
            <div>
                <p>사이트 관리------</p>
                <button onClick={(e) => props.clickEvent(e)} name="dashboard">대시보드</button>
                <button onClick={(e) => props.clickEvent(e)} name="uploadForm">게시물 등록</button>
            </div>
        </div>
    );
}

export default Sidebar;