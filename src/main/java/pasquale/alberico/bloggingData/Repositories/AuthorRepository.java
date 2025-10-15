package pasquale.alberico.bloggingData.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pasquale.alberico.bloggingData.entities.Author;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
