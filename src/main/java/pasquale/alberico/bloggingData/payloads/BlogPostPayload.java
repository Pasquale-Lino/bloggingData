package pasquale.alberico.bloggingData.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BlogPostPayload {
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private String categoria;
    private UUID authorId;
}
