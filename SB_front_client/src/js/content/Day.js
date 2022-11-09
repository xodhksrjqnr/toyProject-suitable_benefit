import {useEffect, useState} from "react";
import '../../css/Time.css'

function Day(props) {
    const [day, setDay] = useState("");

    useEffect(() => {
        setDay("D - " + Math.floor((new Date(props.expirationDate) - Date.now()) / (1000 * 60 * 60 * 24)));
    }, [props]);

    return (
        <div className="day">
            <div>
                <img src="./img/calendar.png" alt="calendar" style={{height:"5vh"}}/>
                <p>{day}</p>
            </div>
        </div>
    );
}

export default Day;