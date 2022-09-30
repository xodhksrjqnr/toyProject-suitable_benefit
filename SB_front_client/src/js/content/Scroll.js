import {ScrollMenu} from "react-horizontal-scrolling-menu";
import {useEffect, useState} from "react";
import Post from "./Post";

import axios from "axios";

import '../../css/Scroll.css';

function Scroll() {
    const [posts, setPost] = useState();

    useEffect(() => {
        axios.get('http://localhost:8080/posts/search')
            .then(response => {
                setPost(response.data.map(post =>
                    <Post key={post.postId} info={post}/>
                ));
            })
    }, []);

    return (
        <ScrollMenu>
            {posts}
        </ScrollMenu>
    );
}

export default Scroll;