package taewan.SBadmin.dto.needDocument;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.NeedDocument;

@Getter
@Setter
@ToString
public class NeedDocumentDto {
    private Long documentId;
    private String name;

    public NeedDocumentDto(NeedDocument needDocument) {
        this.documentId = needDocument.getDocumentId();
        this.name = needDocument.getName();
    }
}
