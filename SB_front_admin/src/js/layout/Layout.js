import React, {useState} from "react";

import 'bootstrap/dist/css/bootstrap.min.css';

import Header from './Header'
import Sidebar from "./Sidebar";
import Dashboard from "../content/Dashboard";
import UploadForm from "../content/uploadForm/UploadForm";


function Layout() {
    const [page, setPage] = useState("dashboard");

    const pageList = {
        dashboard: <Dashboard/>,
        uploadForm: <UploadForm/>
    }

    const sidebarClickEvent = (page) => {
        setPage(page.target.name);
    }

    return (
        <div className="layout">
            <div style={{height:"5vh"}}>
                <Header/>
            </div>
            <div style={{height:"95vh"}}>
                <table style={{border:"none", height:"95vh"}}>
                    <tbody>
                        <tr>
                            <Sidebar clickEvent={sidebarClickEvent}/>
                            {pageList[page]}
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Layout;