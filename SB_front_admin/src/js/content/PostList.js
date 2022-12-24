import {useEffect, useState} from "react";
import axios from "axios";

import '../../css/PostList.css'

function PostList() {
    const [posts, setPosts] = useState();

    const changeVisible = (e, id) => {
        axios.post(process.env.REACT_APP_POSTS + "/" + id + "/activity")
            .then(() =>e.target.innerText = (e.target.innerText === "공개" ? "비공개" : "공개"))
            .catch();
    }

    useEffect(() => {
        axios.get(process.env.REACT_APP_POSTS + "/detail")
            .then(response => {
                    setPosts(response.data.map(post =>
                            <tr key={post.postId} className="post">
                                <td>{post.postId}</td>
                                <td>{post.title}</td>
                                <td>{post.content}</td>
                                <td>{post.createdDate}</td>
                                <td>{post.expirationDate}</td>
                                <td>{post.tags}</td>
                                <td>{post.imgPath}</td>
                                <td>{post.url}</td>
                                <td className="text-center"><button onClick={(e) => changeVisible(e, post.postId)}>
                                    {post.activity ? "공개" : "비공개"}
                                </button></td>
                            </tr>
                    ));
                })
    }, [])

    return (
        <div className="postList">
            <div className="title">
                <h6>등록된 게시물</h6>
            </div>
            <div className="content">
                <div>
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