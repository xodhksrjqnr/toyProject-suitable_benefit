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
            <table>
                <tbody>
                    <tr>
                        <td colSpan="2" className="title">
                            {props.info.title}
                        </td>
                    </tr>
                    <tr className="content">
                        <Day expirationDate={props.info.expirationDate}/>
                        <Percent userBit={props.bit} postBit={props.info.tags}/>
                    </tr>
                    <tr>
                        <td colSpan="2" className="tag">
                            <Tag tags={props.info.tags}/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default SimplePost;