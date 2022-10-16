import {Container} from "react-bootstrap";

function Section(props) {
    return (
        <Container className="px-0 py-3 h-100">
            {props.page}
        </Container>
    );
}

export default Section;