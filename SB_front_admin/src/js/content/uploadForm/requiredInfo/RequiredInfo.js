import NeedList from "./NeedList";
import {useEffect, useState} from "react";
import Container from "react-bootstrap/Container";

function RequiredInfo(props) {
    const [pick, setPick] = useState([]);
    const [bit, setBit] = useState(0n);
    const [tmp , setTmp] = useState([64]);

    useEffect(() => {
        console.log(bit);
        // console.log(pick);
        // console.log(bit);
    }, [pick, bit]);

    const removeNeedElement = (e, id) => {
        const newBit = 1n << id;

        document.getElementById(id).remove();
        setBit(prevBit => prevBit ^ newBit);
        // setBit(prevBit => prevBit)
    }

    const addNeedElement = (e, inputId) => {
        const target = document.getElementById(inputId);
        const id = document.getElementById(target.value).accessKey;
        const newValue = (
            <div id={id} key={id}>
                <p>{target.value}</p>
                <button type="button" onClick={(e) => removeNeedElement(e, id)} className="bg-black">-</button>
            </div>
        );
        const newBit = 1n << id;

        if ((bit & newBit) === 0n) {
            setPick(prevList => [...prevList, newValue]);
            setBit(prevBit => prevBit | newBit);
        }
        target.value = null;
    }

    return (
        <div>
            <input type="text" name={props.need} value={tmp} readOnly hidden/>
            <label htmlFor={props.name}>{props.name}</label>
            <input type="text" id={props.name} placeholder="search for names" list={props.need + "List"}/>
            <button type="button" onClick={(e) => addNeedElement(e, props.name)} className="bg-black">+</button>
            <Container>
                {pick}
            </Container>
            <NeedList need={props.need}/>
        </div>
    );
}

export default RequiredInfo;