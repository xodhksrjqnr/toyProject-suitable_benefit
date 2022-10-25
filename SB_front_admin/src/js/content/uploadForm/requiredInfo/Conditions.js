import {useEffect, useState} from "react";
import axios from "axios";

function Conditions() {
    const [needs, setNeeds] = useState();

    useEffect(() => {
        axios.get('http://localhost:8080/needConditions/search')
            .then(response => {
                setNeeds(response.data.map(data =>
                    <option key={data.name} name={data.conditionId} id={data.name}>{data.name}</option>
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