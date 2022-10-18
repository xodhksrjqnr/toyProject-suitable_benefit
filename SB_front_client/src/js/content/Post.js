import '../../css/Post.css'
import Clock from "./Clock";
import Day from "./Day";

function Post(props) {
    return (
        <div className="post scrollMenu scrollBar">
            <div className="item empty"/>
            <div className="item empty"/>
            <div className="item imgBox shadow">
                <img src={props.post.imgPath} alt="postImg"/>
            </div>
            <div className="item explanation shadow">
                <div>
                    <h6>무엇을 지원해주나요?</h6>
                    <p>{props.post.content}</p>
                </div>
            </div>
            <div className="item expiration shadow">
                <div>
                    <h6>누가 신청할 수 있나요?</h6>
                    <p>{props.post.needConditions}</p>
                </div>
            </div>
            <div className="item expiration shadow">
                <div>
                    <h6>언제까지 신청해야 하나요?</h6>
                    <Day expirationDate={props.post.expirationDate}/>
                    <Clock expirationDate={props.post.expirationDate}/>
                </div>
            </div>
            <div className="item expiration shadow">
                <div>
                    <h6>필요한 서류가 있나요?</h6>
                    <p>{props.post.needDocuments}</p>
                </div>
            </div>
            <div className="item button shadow">
                <div>
                    <h4>If you want</h4>
                    <div>
                        <button onClick={() => window.open(props.post.url)}>Click!</button>
                    </div>
                </div>
            </div>
            <div className="item empty"/>
            <div className="item empty"/>
        </div>
    );
}

export default Post;