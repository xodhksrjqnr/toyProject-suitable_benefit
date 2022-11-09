import {useEffect, useState} from "react";
import '../../css/Percent.css'

function Percent(props) {
    const [percent, setPercent] = useState(0);
    const [circle, setCircle] = useState("");

    const getColor = (ratio) => {
        if (ratio === 0) return "gray";
        else if (ratio <= 25) return "#FF3232";
        else if (ratio <= 50) return "#FFBE0A";
        else if (ratio <= 89) return "#FAF58C";
        else return "#9EF048";
    }

    useEffect(() => {
        const denominator = (props.postBit >>> 0).toString(2).replaceAll('0', '').length;
        const numerator = ((props.userBit & props.postBit) >>> 0).toString(2)
            .replaceAll('0', '').length;
        const ratio = numerator / denominator;
        const offset = (denominator === 0 ? 0 : (1 - ratio) * 214) + "%";
        setPercent(<p style={{color:getColor(ratio * 100)}}>{ratio * 100}</p>);
        setCircle(<circle style={{strokeDashoffset:{offset}, stroke:getColor(ratio * 100)}}/>);
    }, [props])

    return (
        <div className="percent">
            {percent}
            <svg>
                {circle}
            </svg>
        </div>
    );
}

export default Percent;