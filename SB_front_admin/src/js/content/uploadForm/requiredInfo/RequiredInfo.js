import NeedList from "./NeedList";
import {useEffect, useState} from "react";
import Container from "react-bootstrap/Container";

function RequiredInfo(props) {
    const [pick, setPick] = useState([]);
    const [bit, setBit] = useState(0);

    // useEffect(() => {
    //     // console.log(pick);
    //     // console.log(bit);
    // }, [pick, bit]);

    const addNeedElement = (e, inputId) => {
        const target = document.getElementById(inputId);
        const newValue = <p key={target.value.toString()}>{target.value}</p>;
        const newBit = 1 << document.getElementById(target.value).accessKey;

        if ((bit & newBit) === 0) {
            setPick(prevList => [...prevList, newValue]);
            setBit(prevBit => prevBit | newBit);
        }
        target.value = null;
    }

    return (
        <div>
            <input type="text" id={props.name} value={bit} readOnly hidden/>
            <label htmlFor={props.need}>{props.name}</label>
            <input type="text" id={props.need} placeholder="search for names" list={props.need + "List"}/>
            <button type="button" onClick={(e) => addNeedElement(e, props.need)} className="bg-black">+</button>
            <Container>
                {pick}
            </Container>
            <NeedList need={props.need}/>
        </div>
    );
}

export default RequiredInfo;