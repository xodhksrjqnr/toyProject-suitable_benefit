import '../../css/Header.css'

function Header(props) {
    return (
        <div className="header">
            <div></div>
            <div onClick={() => props.clickEvent()}>
                <button>에이드</button>
            </div>
            <div>
                <button onClick={() => props.filterClickEvent()}>Menu</button>
            </div>
        </div>
    );
}

export default Header;