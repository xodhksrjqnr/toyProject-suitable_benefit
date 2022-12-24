import '../../css/SimplePost.css'
import Day from "./Day";
import Percent from "./Percent";
import Tag from "./Tag";

function SimplePost(props) {
    return (
        <div className="shadow simplePost item" onClick={() => props.clickEvent(props.info.postId)}>
            <div>
                <img src={props.info.imgPath} alt="postImg" className="img-fluid"/>
            </div>
            <div className="title">
                <strong>{props.info.title}</strong>
            </div>
            <div className="content">
                <Day expirationDate={props.info.expirationDate}/>
                <Percent userBit={props.bit} postBit={props.info.tags}/>
            </div>
            <div className="tag">
                <Tag tags={props.info.convertedTags}/>
            </div>
        </div>
    );
}

export default SimplePost;