import {useEffect, useState} from "react";
import axios from "axios";

function Conditions() {
    const [needs, setNeeds] = useState();

    useEffect(() => {
        axios.get(process.env.REACT_APP_BASE_URL + process.env.REACT_APP_CONDITION_DATA)
            .then(response => {
                setNeeds(response.data.map(data =>
                    <option key={data.name} accessKey={data.conditionId} id={data.name}>{data.name}</option>
                ));
            });
    }, []);

    return (
        <datalist id="needConditions">
            {needs}
        </datalist>
    );
}

export default Conditions;