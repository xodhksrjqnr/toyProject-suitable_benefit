import {useEffect, useRef, useState} from "react";
import axios from "axios";

import '../../css/PostList.css'

function PostList() {
    const [posts, setPosts] = useState([]);
    const lastPost = useRef();
    const page = useRef(0);

    const changeVisible = (e, id) => {
        axios.get(process.env.REACT_APP_BASE_URL + process.env.REACT_APP_VISIBLE + id).then();
        e.target.innerText = (e.target.innerText === "공개" ? "비공개" : "공개");
    }

    const getPosts = () => {
        axios.get(process.env.REACT_APP_BASE_URL + process.env.REACT_APP_ADMIN_POST_DATA + page.current)
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
                                <td>{post.tags}</td>
                                <td>{post.imgPath}</td>
                                <td>{post.url}</td>
                                <td><button onClick={(e) => changeVisible(e, post.postId)}>
                                    {post.visible ? "공개" : "비공개"}
                                </button></td>
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
        <div className="postList">
            <div>
                <span>등록된 게시물</span>
                <div className="table">
                    <table>
                        <thead>
                            <tr>
                                <th width="5%">번호</th>
                                <th width="10%">제목</th>
                                <th width="25%">내용</th>
                                <th width="10%">등록일</th>
                                <th width="10%">만료일</th>
                                <th width="10%">조건</th>
                                <th width="10%">이미지</th>
                                <th width="10%">URL</th>
                                <th width="10%">공개</th>
                            </tr>
                        </thead>
                        <tbody>
                            {posts}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default PostList;