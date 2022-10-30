import Container from "react-bootstrap/Container";

import '../../../css/UploadForm.css'

import RequiredInfo from "./requiredInfo/RequiredInfo";
import {useState} from "react";
import Image from "react-bootstrap/Image";

function UploadForm() {
    const [imgPath, setImgPath] = useState('/img/noImg.png');

    const renderPreview = () => setImgPath(document.getElementById('imgPath').value);

    return (
        <Container className="p-4 bg-white">
            <div className="text-center mb-5">
                <Image src={imgPath} className="img-fluid"/>
            </div>
            <form className="uploadForm p-4 bg-white" id="postUploadForm" method="post" action="http://localhost:8080/posts/upload">
                <div>
                    <label htmlFor="imgPath">이미지</label>
                    <input type="text" id="imgPath" name="imgPath"/>
                    <button type="button" onClick={() => renderPreview()}>Preview</button>
                </div>
                <div>
                    <label htmlFor="title">제목</label>
                    <input type="text" id="title" name="title"/>
                </div>
                <div>
                    <label htmlFor="content">내용</label>
                    <textarea id="content" name="content" col="20" wrap="hard"/>
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