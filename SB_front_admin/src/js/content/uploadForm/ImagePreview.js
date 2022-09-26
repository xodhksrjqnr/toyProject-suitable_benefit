import {useState} from "react";

import Image from 'react-bootstrap/Image'


function ImagePreview() {
    const [imageSrc, setImageSrc] = useState('/img/noImg.png');

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
        <div className="text-center mb-5">
            <label htmlFor="image" style={{width:"30%", height:"auto", margin:"0 auto"}}>
                <Image src={imageSrc} className="img-fluid"/>
            </label>
            <input type="file" style={{display: "none"}} id="image" onChange={(e) => {
                encodeFileToBase64(e.target.files[0]);
            }}/>
        </div>
    );
}

export default ImagePreview;