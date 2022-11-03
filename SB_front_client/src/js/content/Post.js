import '../../css/Post.css'
import Clock from "./Clock";
import Day from "./Day";

function Post(props) {
    return (
        <div className="post scrollMenu scrollBar">
            <div className="item empty"/>
            <div className="item imgBox shadow">
                <img src={props.post.imgPath} alt="postImg"/>
            </div>
            <div className="item explanation shadow">
                <div>
                    <h6>무엇을 지원해주나요?</h6>
                    <pre>{props.post.content}</pre>
                </div>
            </div>
            <div className="item expiration shadow">
                <div>
                    <h6 style={{height:"5%"}}>누가 신청할 수 있나요?</h6>
                    <div style={{height:"85%"}}>
                        {props.post.convertedTags.map(tag =>
                            <div className="mx-1" style={{display:"inline-block", fontSize:"1rem"}} key={tag}>{tag}</div>
                        )}
                    </div>
                    <div style={{height:"5%", fontSize:"5px"}}>❉ 자세한 신청 조건을 꼭 확인하세요! ❉</div>
                </div>
            </div>
            <div className="item expiration shadow">
                <div>
                    <h6>언제까지 신청해야 하나요?</h6>
                    <table className="w-100" style={{height:"75%"}}>
                        <tbody>
                            <tr style={{height:"50%"}}>
                                <Day expirationDate={props.post.expirationDate}/>
                            </tr>
                            <tr style={{height:"50%"}}>
                                <Clock expirationDate={props.post.expirationDate}/>
                            </tr>
                        </tbody>
                    </table>
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
        </div>
    );
}

export default Post;