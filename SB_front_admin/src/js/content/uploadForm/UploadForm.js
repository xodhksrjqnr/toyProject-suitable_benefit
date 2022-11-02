import '../../../css/UploadForm.css'

import RequiredInfo from "./requiredInfo/RequiredInfo";
import {useState} from "react";

function UploadForm() {
    const [imgPath, setImgPath] = useState('/img/noImg.png');

    const renderPreview = () => setImgPath(document.getElementById('imgPath').value);

    return (
        <div className="uploadForm">
            <div className="imgBox">
                <img src={imgPath} alt="preview" className="img-fluid"/>
            </div>
            <div className="content">
                <form id="postUploadForm" method="post" action="http://localhost:8080/posts/upload">
                    <table>
                        <tbody>
                            <tr>
                                <td>이미지</td>
                                <td>
                                    <input type="text" id="imgPath" name="imgPath"/>
                                    <button type="button" onClick={() => renderPreview()}>Preview</button>
                                </td>
                            </tr>
                            <tr>
                                <td>제목</td>
                                <td><input type="text" id="title" name="title"/></td>
                            </tr>
                            <tr>
                                <td>내용</td>
                                <td><textarea id="content" name="content" col="20" wrap="hard"/></td>
                            </tr>
                            <tr>
                                <td>만료일</td>
                                <td><input type="datetime-local" id="expirationDate" name="expirationDate"/></td>
                            </tr>
                            <tr>
                                <td>URL</td>
                                <td><input type="text" id="url" name="url"/></td>
                            </tr>
                            <tr>
                                <td>필요조건</td>
                                <td><RequiredInfo/></td>
                            </tr>
                        </tbody>
                    </table>
                    <div>
                        <button type="submit" form="postUploadForm">등록하기</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default UploadForm;