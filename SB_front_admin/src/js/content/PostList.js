import {useEffect, useRef, useState} from "react";
import axios from "axios";

import '../../css/PostList.css'

function PostList() {
    const [posts, setPosts] = useState([]);
    const lastPost = useRef();
    const page = useRef(0);

    const getPosts = () => {
        axios.get('http://localhost:8080/posts/search/' + page.current)
            .then(response => {
                if (response.data.length !== 0) {
                    const newPosts = [];
                    response.data.forEach(post => {
                        newPosts.push(
                            <tr key={post.postId} className="post">
                                <td>{post.postId}</td>
                                <td>{post.title}</td>
                                <td>{post.content}</td>
                                <td>{post.createdDate}</td>
                                <td>{post.expirationDate}</td>
                                <td>{post.needConditions}</td>
                                <td>{post.imgPath}</td>
                                <td>{post.url}</td>
                            </tr>
                        );
                    });
                    setPosts(prevPosts => prevPosts.concat(newPosts));
                }
            })
        page.current++;
    }

    const addNewPosts = (entries, observer) => {
        if (entries[0].isIntersecting) {
            observer.unobserve(lastPost.current);
            getPosts();
        }
    }

    const observer = useRef(new IntersectionObserver(addNewPosts));

    useEffect(() => {
        if (posts.length === 0)
            page.current = 0;
        lastPost.current = document.querySelector(
            posts.length === 0 ? ".table" : ".post:last-of-type"
        );
        observer.current.observe(lastPost.current);
    }, [posts])

    return (
        <div>
            <p>등록된 게시물</p>
            <div className="bg-white w-100 table" style={{overflow:"scroll", height:"30vh"}}>
                <table>
                    <thead>
                        <tr>
                            <th width="6%">번호</th>
                            <th width="15%">제목</th>
                            <th width="29%">내용</th>
                            <th width="10%">등록일</th>
                            <th width="10%">만료일</th>
                            <th width="10%">조건</th>
                            <th width="10%">이미지</th>
                            <th width="10%">URL</th>
                        </tr>
                    </thead>
                    <tbody>
                        {posts}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default PostList;