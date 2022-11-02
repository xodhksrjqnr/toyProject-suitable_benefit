import {useEffect, useState} from "react";
import axios from "axios";
import '../../css/ConditionList.css'

function ConditionList() {
    const [conditions, setConditions] = useState([]);

    const addCondition = () => {
        const target = document.getElementById("newCondition");
        if (!target.value) return;
        axios.get('http://localhost:8080/needConditions/upload/' + target.value)
            .then(response => {
                const condition = <span key={target.value}>{target.value}</span>;
                setConditions(prev => prev.concat(condition));
                target.value = null;
            });
    }

    useEffect(() => {
        axios.get('http://localhost:8080/needConditions/search')
            .then(response => {
                setConditions(response.data.map(data =>
                    <span key={data.name}>{data.name}</span>
                ));
            });
    }, []);

    return (
        <div className="conditionList">
            <span>등록된 조건</span>
            <input type="text" id="newCondition"/>
            <button onClick={() => addCondition()}>추가</button>
            <div>
                {conditions}
            </div>
        </div>
    );
}

export default ConditionList;