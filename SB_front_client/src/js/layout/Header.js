import '../../css/Header.css'
import MenuPopup from "../content/MenuPopup";
import {useState} from "react";

function Header(props) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <div className="header">
            <div></div>
            <div onClick={() => props.clickEvent()}>
                <button>에이드</button>
            </div>
            <div>
                <button onClick={() => setIsOpen(!isOpen)}>Menu</button>
            </div>
            {isOpen && <MenuPopup userBit={props.userBit} bitEvent={props.bitEvent}/>}
        </div>
    );
}

export default Header;