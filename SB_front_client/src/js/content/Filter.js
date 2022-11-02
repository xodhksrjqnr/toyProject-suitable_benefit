import '../../css/Filter.css'
import {useEffect, useRef, useState} from "react";
import axios from "axios";

function Filter (props) {
    const [conditions, setConditions] = useState([]);
    const curBit = useRef(props.userBit.current);

    const isCheck = (id) => {
        return (((1 << (id - 1)) & curBit.current) === 0) ? "uncheck" : "check";
    }

    const filterClickEvent = (e) => {
        const target = document.getElementById(e.target.id);
        const tmpBit = 1 << (e.target.name - 1);

        if ((curBit.current & tmpBit) === 0) {
            curBit.current |= tmpBit;
            target.className = "check";
        } else {
            curBit.current ^= tmpBit;
            target.className = "uncheck";
        }
    }

    const getConditions = () => {
        axios.get('http://localhost:8080/needConditions/search')
            .then(response => {
                const newConditions = [];
                response.data.forEach(data => {
                    newConditions.push(
                        <button key={data.conditionId} id={data.name}
                                name={data.conditionId} className={isCheck(data.conditionId)}
                                onClick={(e) => filterClickEvent(e)}>{data.name}</button>
                    )
                });
                setConditions(prevConditions => prevConditions.concat(newConditions));
            });
    }

    useEffect(() => {
        getConditions();
    }, [])

    return (
        <div className="filter">
            <div>
                {conditions}
            </div>
            <button onClick={() => props.bitEvent(curBit.current)}>완료</button>
        </div>
    );
}

export default Filter;