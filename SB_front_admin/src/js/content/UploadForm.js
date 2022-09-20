import Button from "react-bootstrap/Button";

import '../../css/UploadForm.css'

import ImagePreview from "./ImagePreview";

function UploadForm() {
    return (
        <form className="uploadForm">
            <div>
                <label for="title">제목</label>
                <input type="text" id="title" className=""/>
            </div>
            <ImagePreview/>
            <div>
                <label for="content">내용</label>
                <input type="text" id="content"/>
            </div>
            <div>
                <label for="expirationDate">만료일</label>
                <input type="date" id="expirationDate"/>
            </div>
            <div>
                <p>needConditions</p>
            </div>
            <div>
                <p>needDocuments</p>
            </div>
            <div>
                <p>procedure</p>
            </div>
            <Button>test</Button>
        </form>
    );
}

export default UploadForm;