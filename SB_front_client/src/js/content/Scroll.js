import {useEffect, useRef, useState} from "react";

import axios from "axios";
import SimplePost from "./SimplePost";
import '../../css/Scroll.css';


function Scroll(props) {
    const [posts, setPosts] = useState([]);
    const lastPost = useRef();
    let page = 0;

    const getPosts = () => {
        axios.get('http://localhost:8080/posts/search/' + page)
            .then(response => {
                const newPosts = response.data.map(post =>
                    <SimplePost key={post.postId} info={post} bit={props.userBit} clickEvent={props.clickEvent}/>
                );
                setPosts(prevPosts => prevPosts.concat(newPosts));
            })
        page++;
    }

    const addNewPosts = async (entries, observer) => {
        if (entries[0].isIntersecting) {
            observer.unobserve(lastPost.current);
            getPosts();
        }
    }

    const observer = useRef(new IntersectionObserver(addNewPosts));

    useEffect(() => {
        getPosts();
    }, [])

    useEffect(() => {
        try {
            lastPost.current = document.querySelector(".post:last-of-type");
            observer.current.observe(lastPost.current);
        } catch (error) {
        }
    }, [posts])

    return (
        <div className="scrollMenu scrollBar">
            {posts}
        </div>
    );
}

export default Scroll;