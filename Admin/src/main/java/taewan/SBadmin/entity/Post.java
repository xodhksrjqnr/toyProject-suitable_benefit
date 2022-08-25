package taewan.SBadmin.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;

    private String title;
    private String imgPath;
    private String content;
    private int totalVote;
    private int positive;

    @CreatedDate
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;
    private Long needConditions;
    private Long needDocuments;
    private String procedure;

    @Builder
    public Post(String title, String imgPath, String content, LocalDateTime expirationDate, Long needConditions, Long needDocuments, String procedure) {
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.totalVote = 0;
        this.positive = 0;
        this.expirationDate = expirationDate;
        this.needConditions = needConditions;
        this.needDocuments = needDocuments;
        this.procedure = procedure;
    }

    @Override
    public String toString() {
        return this.title + "\n" +
                this.imgPath + "\n" +
                this.content + "\n" +
                this.totalVote + "\n" +
                this.positive + "\n" +
                this.createdDate + "\n" +
                this.expirationDate + "\n" +
                this.needConditions + "\n" +
                this.needDocuments + "\n" +
                this.procedure;
    }
}
