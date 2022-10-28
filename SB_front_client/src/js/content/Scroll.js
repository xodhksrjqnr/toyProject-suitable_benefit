import {useEffect, useRef, useState} from "react";

import axios from "axios";
import SimplePost from "./SimplePost";
import '../../css/Scroll.css';


function Scroll(props) {
    const [posts, setPosts] = useState([]);
    const lastPost = useRef();
    const page = useRef(0);

    const isValid = (postBit) => {
        if (props.userBit.current !== 0 && (props.userBit.current & postBit) === 0)
            return false;
        return true;
    }

    const getPosts = () => {
        axios.get('http://localhost:8080/posts/search/' + page.current + '/' + props.userBit.current)
            .then(response => {
                const newPosts = [];
                response.data.forEach(post => {
                    if (isValid(post.needConditions))
                        newPosts.push(<SimplePost key={post.postId} info={post} bit={props.userBit.current} clickEvent={props.clickEvent}/>);
                })
                setPosts(prevPosts => prevPosts.concat(newPosts));
            })
        page.current++;
    }

    const addNewPosts = async (entries, observer) => {
        if (entries[0].isIntersecting) {
            observer.unobserve(lastPost.current);
            getPosts();
        }
    }

    const observer = useRef(new IntersectionObserver(addNewPosts));

    useEffect(() => {
        if (posts.length === 0) {
            page.current = 0;
            lastPost.current = document.querySelector(".scrollMenu");
            observer.current.observe(lastPost.current);
        } else {
            try {
                lastPost.current = document.querySelector(".simplePost:last-of-type");
                observer.current.observe(lastPost.current);
            } catch (error) {}
        }
    }, [posts])

    return (
        <div className="scrollMenu scrollBar">
            {posts}
        </div>
    );
}

export default Scroll;