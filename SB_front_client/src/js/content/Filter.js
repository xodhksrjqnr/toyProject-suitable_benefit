import '../../css/Filter.css'
import {useEffect, useRef, useState} from "react";
import axios from "axios";

function Filter (props) {
    const [tags, setTags] = useState([]);
    const curBit = useRef(props.userBit.current);

    const isCheck = (id) => {
        return (((1 << (id - 1)) & curBit.current) === 0) ? "uncheck" : "check";
    }

    const filterClickEvent = (e) => {
        const target = document.getElementById(e.target.id);
        const tmpBit = 1 << (e.target.name - 1);

        if ((curBit.current & tmpBit) === 0) {
            curBit.current |= tmpBit;
            target.className = "check";
        } else {
            curBit.current ^= tmpBit;
            target.className = "uncheck";
        }
    }

    const getTags = () => {
        axios.get(process.env.REACT_APP_TAGS)
            .then(response => {
                const newTags = [];
                response.data.forEach(data => {
                    newTags.push(
                        <button key={data.tagId} id={data.name}
                                name={data.tagId} className={isCheck(data.tagId)}
                                onClick={(e) => filterClickEvent(e)}>{data.name}</button>
                    )
                });
                setTags(prevTags => prevTags.concat(newTags));
            });
    }

    useEffect(() => {
        getTags();
    }, [])

    return (
        <div className="filter">
            <div>
                {tags}
            </div>
            <button onClick={() => props.bitEvent(curBit.current)}>완료</button>
        </div>
    );
}

export default Filter;