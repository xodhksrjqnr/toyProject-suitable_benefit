import axios from "axios";
import {useEffect, useState} from "react";
import Post from "./Post";
import '../../css/Scroll.css';

function PostPage(props) {
    const [post, setPost] = useState();

    const getPost = () => {
        axios.get(process.env.REACT_APP_BASE_URL + process.env.REACT_APP_POST_ONE + props.postNum)
            .then(response => {
                const post = response.data;
                setPost(
                    <Post key={post.postId} post={post}/>
                );
            })
    }

    useEffect(() => {
        getPost();
    }, [])

    return (
        <div className="postPage px-0" style={{height: "80vh"}}>
            {post}
        </div>
    );
}

export default PostPage;