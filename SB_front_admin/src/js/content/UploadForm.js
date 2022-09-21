import Container from "react-bootstrap/Container";

import '../../css/UploadForm.css'

import ImagePreview from "./ImagePreview";
import RequiredInfo from "./RequiredInfo";

function UploadForm() {
    return (
        <Container className="p-4">
            <form className="uploadForm p-4 bg-white">
                <ImagePreview/>
                <div>
                    <label htmlFor="title">제목</label>
                    <input type="text" id="title" className=""/>
                </div>
                <div>
                    <label htmlFor="content">내용</label>
                    <input type="text" id="content"/>
                </div>
                <div>
                    <label htmlFor="expirationDate">만료일</label>
                    <input type="date" id="expirationDate"/>
                </div>
                <RequiredInfo need="needConditions" name="필요 조건"/>
                <RequiredInfo need="needDocuments" name="필요 서류"/>
                <div>
                    <p>procedure</p>
                </div>
            </form>
        </Container>
    );
}

export default UploadForm;