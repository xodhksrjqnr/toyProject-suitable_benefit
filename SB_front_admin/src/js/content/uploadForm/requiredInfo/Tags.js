import {useEffect, useState} from "react";
import axios from "axios";

function Tags() {
    const [needs, setNeeds] = useState();

    useEffect(() => {
        axios.get(process.env.REACT_APP_BASE_URL + process.env.REACT_APP_TAG_DATA)
            .then(response => {
                setNeeds(response.data.map(data =>
                    <option key={data.name} accessKey={data.tagId} id={data.name}>{data.name}</option>
                ));
            });
    }, []);

    return (
        <datalist id="tags">
            {needs}
        </datalist>
    );
}

export default Tags;