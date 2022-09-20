import {useState} from "react";

function ImagePreview() {
    const [imageSrc, setImageSrc] = useState('');

    const encodeFileToBase64 = (fileBlob) => {
        const reader = new FileReader();
        reader.readAsDataURL(fileBlob);
        return new Promise((resolve) => {
            reader.onload = () => {
                setImageSrc(reader.result);
                resolve();
            };
        });
    };

    return (
        <div className="imagePreview">
            <input type="image" src="/img/noImg.png" alt="no image" id="image" onChange={(e) => {
                encodeFileToBase64(e.target.files[0]);
            }}/>
            <div className="preview">
                {imageSrc && <img src={imageSrc} alt="preview-img" />}
            </div>
        </div>
    );
}

export default ImagePreview;