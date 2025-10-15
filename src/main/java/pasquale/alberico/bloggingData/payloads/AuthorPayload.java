package pasquale.alberico.bloggingData.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorPayload {
    private String nome;
    private String cognome;
    private String email;
    private String avatar;
}
