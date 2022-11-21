import Tags from "./Tags";
import {useRef, useState} from "react";

function RequiredInfo() {
    const [pick, setPick] = useState([]);
    const tmpBit = useRef(0);

    const removeNeedElement = (id) => {
        const newBit = 1 << (id - 1);

        document.getElementById(id).remove();
        tmpBit.current ^= newBit;
    }

    const addNeedElement = () => {
        const target = document.getElementById("필요조건");
        if (!target.value) return;
        const id = document.getElementById(target.value).accessKey;
        const newBit = 1 << (id - 1);

        if ((tmpBit.current & newBit) === 0) {
            const newValue = (
                <div id={id} key={id} style={{display:"inline-block"}}>
                    <span>{target.value}</span>
                    <button type="button" style={{border:"none", backgroundColor:"white"}}
                            onClick={() => removeNeedElement(id)} className="bg-black">-</button>
                </div>
            );
            setPick(prevList => prevList.concat(newValue));
            tmpBit.current |= newBit;
        }
        target.value = null;
    }

    return (
        <div>
            <input type="text" name="tags" value={tmpBit.current} readOnly hidden/>
            <input type="text" style={{width:"80%"}} id="필요조건" placeholder="search for name" list="tags"/>
            <button type="button" style={{border:"none", borderRadius:"10px"}} onClick={() => addNeedElement()}>+</button>
            <div style={{position:"relative", overflowY:"scroll"}}>
                {pick}
            </div>
            <Tags/>
        </div>
    );
}

export default RequiredInfo;