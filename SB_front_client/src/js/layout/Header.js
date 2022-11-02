import '../../css/Header.css'

function Header(props) {
    return (
        <div className="header">
            <div></div>
            <div>
                <button onClick={() => props.clickEvent()}>에이드</button>
            </div>
            <div>
                <button onClick={() => props.filterClickEvent()}>
                    <img src="./img/filter.png" alt="filter" style={{height:"5vh"}}/>
                </button>
            </div>
        </div>
    );
}

export default Header;