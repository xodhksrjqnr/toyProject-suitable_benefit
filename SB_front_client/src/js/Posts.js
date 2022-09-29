import axios from "axios";
import {useEffect, useState} from "react";

function Posts() {
    const [posts, setPost] = useState();
    const curDate = Date.now();

    useEffect(() => {
        axios.get('http://localhost:8080/posts/search')
            .then(response => {
                setPost(response.data.map(post =>
                    <div key={post.postId}>
                        <img src={post.imgPath} alt="postImg"/>
                        <p>{post.title}</p>
                        <p>{Math.floor((new Date(post.expirationDate) - curDate) / (1000 * 60 * 60 * 24))}</p>
                        <p>{post.needConditions}</p>
                    </div>
                ));
            })
    }, []);

    return (
        <div>
            {posts}
        </div>
    );
}

export default Posts;