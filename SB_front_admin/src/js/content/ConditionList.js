import {useEffect, useState} from "react";
import axios from "axios";

function ConditionList() {
    const [conditions, setConditions] = useState([]);

    const addCondition = () => {
        const target = document.getElementById("newCondition");
        if (!target.value) return;
        axios.get('http://localhost:8080/needConditions/upload/' + target.value)
            .then(response => {
                const condition = <p key={target.value}>{target.value}</p>;
                setConditions(prev => prev.concat(condition));
                target.value = null;
            });
    }

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
            <span>등록된 조건</span>
            <input type="text" id="newCondition"/>
            <button className="bg-black" onClick={() => addCondition()}>추가</button>
            <div className="bg-white">
                {conditions}
            </div>
        </div>
    );
}

export default ConditionList;