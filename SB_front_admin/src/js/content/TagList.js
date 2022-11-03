import {useEffect, useState} from "react";
import axios from "axios";
import '../../css/TagList.css'

function TagList() {
    const [tags, setTags] = useState([]);

    const addTag = () => {
        const target = document.getElementById("newTag");
        if (!target.value) return;
        axios.post(process.env.REACT_APP_POSTS + "/" + target.value)
            .then(response => {
                const tag = <span key={target.value}>{target.value}</span>;
                setTags(prev => prev.concat(tag));
                target.value = null;
            });
    }

    useEffect(() => {
        axios.get(process.env.REACT_APP_TAGS)
            .then(response => {
                setTags(response.data.map(data =>
                    <span key={data.name}>{data.name}</span>
                ));
            });
    }, []);

    return (
        <div className="tagList">
            <span>등록된 조건</span>
            <input type="text" id="newTag"/>
            <button onClick={() => addTag()}>추가</button>
            <div>
                {tags}
            </div>
        </div>
    );
}

export default TagList;