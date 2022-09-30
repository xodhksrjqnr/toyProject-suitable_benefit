
function Post(props) {
    const curDate = Date.now();

    return (
        <div style={{
            display: "inline-block",
            margin: "0 5vw",
            width: "20vw",
            border: "solid 5px",
            borderRadius: "10px"
        }}
        >
            <img src={props.info.imgPath} alt="postImg" className="img-fluid rounded-1"/>
            <div>{props.info.title}</div>
            <div>{Math.floor((new Date(props.info.expirationDate) - curDate) / (1000 * 60 * 60 * 24))}</div>
            {/*<div>{props.info.needConditions}</div>*/}
        </div>
    );
}

export default Post;