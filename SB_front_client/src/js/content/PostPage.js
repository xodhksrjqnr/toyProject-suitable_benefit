import axios from "axios";
import {useEffect, useState} from "react";
import Post from "./Post";
import '../../css/Scroll.css';

function PostPage(props) {
    const [post, setPost] = useState();

    useEffect(() => {
        axios.get(process.env.REACT_APP_POSTS + "/" + props.postNum)
            .then(response => {
                const post = response.data;
                if (response.data !== null)
                    setPost(<Post key={post.postId} post={post}/>);
            })
    }, [props])

    return (
        <div className="postPage px-0" style={{height: "80vh"}}>
            {post}
        </div>
    );
}

export default PostPage;