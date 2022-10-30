import {useEffect, useState} from "react";
import axios from "axios";

function ConditionList() {
    const [conditions, setConditions] = useState();

    useEffect(() => {
        axios.get('http://localhost:8080/needConditions/search')
            .then(response => {
                setConditions(response.data.map(data =>
                    <p key={data.name}>{data.name}</p>
                ));
            });
    }, []);

    return (
        <div>
            <p>등록된 조건</p>
            <div className="bg-white">
                {conditions}
            </div>
        </div>
    );
}

export default ConditionList;