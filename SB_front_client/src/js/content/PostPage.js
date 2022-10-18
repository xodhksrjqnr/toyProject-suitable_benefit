import axios from "axios";
import {useEffect, useState} from "react";
import Post from "./Post";
import '../../css/Scroll.css';

function PostPage(props) {
    const [post, setPost] = useState();

    const getPost = () => {
        axios.get('http://localhost:8080/posts/' + props.postNum)
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
        <div className="postPage h-100 px-0">
            {post}
        </div>
    );
}

export default PostPage;