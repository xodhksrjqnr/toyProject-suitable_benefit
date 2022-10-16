import axios from "axios";
import {useEffect, useState} from "react";
import {Container} from "react-bootstrap";

function PostPage(props) {
    const [post, setPost] = useState();

    const getPost = () => {
        axios.get('http://localhost:8080/posts/' + props.postNum)
            .then(response => {
                const post = response.data;
                console.log(post)
                setPost(
                    <div>
                        <img src={post.imgPath} alt="postImg"/>
                        <p>{post.postId}</p>
                        <p>{post.title}</p>
                        <p>{post.content}</p>
                        <p>{post.createdDate}</p>
                        <p>{post.expirationDate}</p>
                        <p>{post.needConditions}</p>
                        <p>{post.needDocuments}</p>
                        <p>{post.url}</p>
                    </div>
                );
            })
    }

    useEffect(() => {
        getPost();
    }, [])

    return (
        <Container>
            {post}
        </Container>
    );
}

export default PostPage;