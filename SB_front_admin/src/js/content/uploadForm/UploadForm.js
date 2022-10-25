import Container from "react-bootstrap/Container";

import '../../../css/UploadForm.css'

import ImagePreview from "./ImagePreview";
import RequiredInfo from "./requiredInfo/RequiredInfo";

function UploadForm() {
    return (
        <Container className="p-4">
            <form className="uploadForm p-4 bg-white" id="postUploadForm" method="post" action="http://localhost:8080/posts/upload">
                <ImagePreview/>
                <div>
                    <label htmlFor="title">제목</label>
                    <input type="text" id="title" name="title"/>
                </div>
                <div>
                    <label htmlFor="content">내용</label>
                    <input type="text" id="content" name="content"/>
                </div>
                <div>
                    <label htmlFor="expirationDate">만료일</label>
                    <input type="datetime-local" id="expirationDate" name="expirationDate"/>
                </div>
                <div>
                    <label htmlFor="url">URL</label>
                    <input type="text" id="url" name="url"/>
                </div>
                <RequiredInfo/>
                <div>
                    <button type="submit" form="postUploadForm">등록하기</button>
                </div>
            </form>
        </Container>
    );
}

export default UploadForm;