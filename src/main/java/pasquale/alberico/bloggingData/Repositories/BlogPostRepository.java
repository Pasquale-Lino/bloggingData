package pasquale.alberico.bloggingData.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pasquale.alberico.bloggingData.entities.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
