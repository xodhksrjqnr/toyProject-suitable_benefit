package taewan.SBadmin.dto.needDocument;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NeedDocumentDto {
    private Long documentId;
    private String name;

    public NeedDocumentDto(Long documentId, String name) {
        this.documentId = documentId;
        this.name = name;
    }
}
