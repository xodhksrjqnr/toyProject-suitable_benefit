import {useEffect, useRef, useState} from "react";

import axios from "axios";
import SimplePost from "./SimplePost";
import '../../css/Scroll.css';


function Scroll(props) {
    const [posts, setPosts] = useState([]);
    const lastPost = useRef();
    const flag = useRef(false);
    const postNum = useRef(0);

    const getPosts = () => {
        axios.get(process.env.REACT_APP_POSTS + "/" + postNum.current + "/" + props.userBit.current)
            .then(response => {
                if (response.data.length !== 0) {
                    const newPosts = [];
                    response.data.forEach(post => {
                        newPosts.push(<SimplePost key={post.postId} info={post} bit={props.userBit.current}
                                                  clickEvent={props.clickEvent}/>);
                    });
                    setPosts(prevPosts => prevPosts.concat(newPosts));
                    postNum.current = response.data[response.data.length - 1].postId;
                }
                if (response.data.length > 10)
                    flag.current = false;
            })
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
            postNum.current = 0;
        if (!flag.current) {
            flag.current = true;
            lastPost.current = document.querySelector(
                posts.length === 0 ? ".scrollMenu" : ".simplePost:last-of-type"
            );
            observer.current.observe(lastPost.current);
        }
    }, [posts])

    return (
        <div className="scrollMenu scrollBar">
            {posts}
        </div>
    );
}

export default Scroll;