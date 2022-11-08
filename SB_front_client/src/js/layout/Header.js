import '../../css/Header.css'

function Header(props) {
    return (
        <div className="header">
            <div className="logo">
                <button onClick={() => props.clickEvent()}>
                    <img src="./img/logo.png" alt="logo" style={{height:"5vh"}}/>
                </button>
            </div>
            <div></div>
            <div className="group">
                <button onClick={() => props.filterClickEvent()}>
                    <img src="./img/filter.png" alt="filter"/>
                </button>
                <button>
                    <img src="./img/login.png" alt="login"/>
                </button>
            </div>
        </div>
    );
}

export default Header;