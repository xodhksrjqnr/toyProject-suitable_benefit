import {useEffect, useState} from "react";
import '../../css/Tag.css'

function Tag(props) {
    const [tags, setTags] = useState([]);

    const tagFormatting = (name) => {
        return <div key={name} className="tagFormat">{name}</div>
    }

    useEffect(() => {
        props.tags.forEach(tag => setTags(
            prevTag => prevTag.concat(tagFormatting(tag))));
    }, [props])

    return (
        <div style={{overflowY:"scroll"}}>
            {tags}
        </div>
    );
}

export default Tag;