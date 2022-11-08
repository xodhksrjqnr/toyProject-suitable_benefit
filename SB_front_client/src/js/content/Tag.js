import {useEffect, useState} from "react";
import axios from "axios";
import '../../css/Tag.css'

function Tag(props) {
    const [tags, setTags] = useState([]);

    const tagFormatting = (name) => {
        return <div key={name} className="tagFormat">{name}</div>
    }

    useEffect(() => {
        axios.get(process.env.REACT_APP_TAGS)
            .then(response => {
                const valid = [];
                response.data.forEach(tag => {
                    if ((props.tags & (1 << (tag.tagId - 1))) !== 0)
                        valid.push(tagFormatting(tag.name));
                });
                setTags(valid);
            })
    }, [props])

    return (
        <div style={{overflowY:"scroll"}}>
            {tags}
        </div>
    );
}

export default Tag;