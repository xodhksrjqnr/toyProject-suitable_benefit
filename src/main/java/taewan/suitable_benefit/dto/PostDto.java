package taewan.suitable_benefit.dto;

public class PostDto {
    private String img;
    private String content;

    public PostDto() {
        this.img = "http://www.gangnam.go.kr/upload/editor/2020/02/04/d7bc119e-f734-45ca-8fe9-9886714d68a9.jpg";
        this.content = "대학 등록금이 필요하다면?";
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
