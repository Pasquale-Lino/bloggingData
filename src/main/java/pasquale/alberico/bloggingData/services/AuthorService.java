package pasquale.alberico.bloggingData.services;

import pasquale.alberico.bloggingData.entities.Author;
import pasquale.alberico.bloggingData.payloads.AuthorPayload;
import pasquale.alberico.bloggingData.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(UUID id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Autore non trovato con id " + id));
    }

    public Author save(AuthorPayload payload) {
        
        Author author = new Author();
        author.setNome(payload.getNome());
        author.setCognome(payload.getCognome());
        author.setEmail(payload.getEmail());
        author.setAvatar(payload.getAvatar() != null ? payload.getAvatar() : "https://picsum.photos/200");
        return authorRepository.save(author);
    }

    public Author update(UUID id, AuthorPayload payload) {
        Author author = findById(id);
        author.setNome(payload.getNome());
        author.setCognome(payload.getCognome());
        author.setEmail(payload.getEmail());
        author.setAvatar(payload.getAvatar());
        return authorRepository.save(author);
    }

    public void delete(UUID id) {
        authorRepository.deleteById(id);
    }
}
