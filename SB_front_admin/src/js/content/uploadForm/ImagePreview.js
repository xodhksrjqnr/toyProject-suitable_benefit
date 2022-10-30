import {useState} from "react";

import Image from 'react-bootstrap/Image'


function ImagePreview() {
    const [imgPath, setImgPath] = useState('/img/noImg.png');

    const renderPreview = () => setImgPath(document.getElementById('imgPath').value);

    return (
        <div>
            <div className="text-center mb-5">
                <Image src={imgPath} className="img-fluid"/>
            </div>
            <label htmlFor="imgPath">이미지</label>
            <input type="text" id="imgPath" name="imgPath"/>
            <button type="button" onClick={() => renderPreview()}>Preview</button>
        </div>
    );
}

export default ImagePreview;