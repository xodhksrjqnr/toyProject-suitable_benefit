import {useEffect, useRef, useState} from "react";
import axios from "axios";

function NeedList(props) {
    const [needs, setNeeds] = useState();

    useEffect(() => {
        axios.get('http://localhost:8080/indexInfo/' + props.need)
            .then(response => {
                setNeeds(response.data.map(data =>
                    <option key={data.key} accessKey={data.key} id={data.name}>{data.name}</option>
                ));
            });
    }, [props]);

    return (
        <datalist id={props.need + "List"}>
            {needs}
        </datalist>
    );
}

export default NeedList;