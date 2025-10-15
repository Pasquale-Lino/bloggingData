package pasquale.alberico.bloggingData.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private String cover;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
