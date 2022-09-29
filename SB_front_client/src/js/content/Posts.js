import axios from "axios";
import {useEffect, useState} from "react";
import {Container} from "react-bootstrap";

function Posts() {
    const [posts, setPost] = useState();

    useEffect(() => {
        axios.get('http://localhost:8080/posts/search')
            .then(response => {
                const curDate = Date.now();
                setPost(response.data.map(post =>
                    <Container key={post.postId}>
                        <img src={post.imgPath} alt="postImg"/>
                        <p>{post.title}</p>
                        <p>{Math.floor((new Date(post.expirationDate) - curDate) / (1000 * 60 * 60 * 24))}</p>
                        <p>{post.needConditions}</p>
                    </Container>
                ));
            })
    }, []);

    return (
        <Container>
            {posts}
        </Container>
    );
}

export default Posts;