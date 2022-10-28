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
                    <p>{props.post.content}</p>
                </div>
            </div>
            <div className="item expiration shadow">
                <div>
                    <h6 style={{height:"5%"}}>누가 신청할 수 있나요?</h6>
                    <div style={{height:"85%"}}>
                        {props.post.convertedConditions.map(condition =>
                            <div className="mx-1" style={{display:"inline-block", fontSize:"10px"}} key={condition}>{condition}</div>
                        )}
                    </div>
                    <div style={{height:"5%", fontSize:"5px"}}>❉ 자세한 신청 조건을 꼭 확인하세요! ❉</div>
                </div>
            </div>
            <div className="item expiration shadow">
                <div>
                    <h6>언제까지 신청해야 하나요?</h6>
                    <Day expirationDate={props.post.expirationDate}/>
                    <Clock expirationDate={props.post.expirationDate}/>
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