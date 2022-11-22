import {useEffect, useState} from "react";
import axios from "axios";
import '../../css/TagList.css'

function TagList() {
    const [tags, setTags] = useState([]);

    const addTag = () => {
        const target = document.getElementById("newTag");
        if (!target.value || document.getElementById(target.value) !== null) {
            target.value = null;
            return;
        }
        axios.post(process.env.REACT_APP_TAGS + "/" + target.value)
            .then(response => {
                const tag = <div className="tag" key={target.value} id={target.value}>{target.value}</div>;
                setTags(prev => prev.concat(tag));
                target.value = null;
            });
    }

    useEffect(() => {
        axios.get(process.env.REACT_APP_TAGS)
            .then(response => {
                setTags(response.data.map(data =>
                    <div className="tag" key={data.name} id={data.name}>{data.name}</div>
                ));
            });
    }, []);

    return (
        <div className="tagList">
            <div className="title">
                <h6>등록된 조건</h6>
            </div>
            <div className="search">
                <input type="text" id="newTag"/>
                <button onClick={() => addTag()}>추가</button>
            </div>
            <div className="content">
                <div>
                    {tags}
                </div>
            </div>
        </div>
    );
}

export default TagList;