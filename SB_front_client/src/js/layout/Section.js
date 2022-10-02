import Scroll from "../content/Scroll";
import {Container} from "react-bootstrap";

function Section() {
    const userBit = 1630063798920911600;

    return (
        <Container className="px-0 py-3 h-100">
            <Scroll userBit={userBit}/>
        </Container>
    );
}

export default Section;