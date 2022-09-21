import {useEffect, useState} from "react";
import axios from "axios";
import {Dropdown, DropdownButton} from "react-bootstrap";

function RequiredInfo(props) {
    const [needs, setNeed] = useState(new Map());

    useEffect(() => {
        axios.get('http://localhost:8080/indexInfo/' + props.need)
            .then((response) => {
                setNeed(response.data.map(data =>
                    <Dropdown.Item key={data.toString()}>{data}</Dropdown.Item>
                ));
            })
            .catch(() => {
                console.log("조건 요청 실패");
            })
    }, [props.need]);

    return (
        <div>
            <label htmlFor="need">{props.name}</label>
            <DropdownButton id="need" title="+">
                {needs}
            </DropdownButton>
        </div>
    );
}

export default RequiredInfo;