package pasquale.alberico.bloggingData.controllers;

import pasquale.alberico.bloggingData.entities.Author;
import pasquale.alberico.bloggingData.payloads.AuthorPayload;
import pasquale.alberico.bloggingData.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable UUID id) {
        return authorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody AuthorPayload payload) {
        return authorService.save(payload);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable UUID id, @RequestBody AuthorPayload payload) {
        return authorService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        authorService.delete(id);
    }
}
