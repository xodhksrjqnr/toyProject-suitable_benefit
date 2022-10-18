import {useEffect, useRef, useState} from "react";
import '../../css/Time.css'

function Clock(props) {
    const [time, setTime] = useState("");
    const timeDiff = Math.floor((new Date(props.expirationDate) - Date.now()) / 1000);
    const hour = useRef(Math.floor(timeDiff / (60 * 60)));
    const minute = useRef(Math.floor((timeDiff % (60 * 60)) / 60));
    const second = useRef(Math.floor(((timeDiff % (60 * 60)) % 60)));

    useEffect(() => {
        if (hour.current === 0 && minute.current === 0 && second.current === 0)
            return ;
        let timer = setInterval(() => {
            setTime(hour.current + ":" + minute.current + ":" + second.current);
            second.current--;
            if (second.current === -1) {
                minute.current--;
                second.current = 59;
            }
            if (minute.current === -1) {
                hour.current--;
                minute.current = 59;
            }
        }, 1000)

        return () => clearInterval(timer);
    }, [])

    return (
        <div className="time">
            <p>{time}</p>
        </div>
    );
}

export default Clock;