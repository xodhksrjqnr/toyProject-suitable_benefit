import {useEffect, useState} from "react";
import '../../css/Percent.css'

function Percent(props) {
    const [percent, setPercent] = useState(0);

    useEffect(() => {
        const denominator = (props.postBit >>> 0).toString(2).replaceAll('0', '').length;
        const numerator = ((props.userBit & props.postBit) >>> 0).toString(2)
            .replaceAll('0', '').length;
        setPercent((numerator / denominator) * 100);
    }, [props])

    return (
        <div className="percent">
            <strong><span>{percent}</span></strong>
        </div>
    );
}

export default Percent;