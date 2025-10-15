package pasquale.alberico.bloggingData.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pasquale.alberico.bloggingData.entities.BlogPost;
import pasquale.alberico.bloggingData.payloads.BlogPostPayload;
import pasquale.alberico.bloggingData.services.BlogPostService;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;
    @GetMapping
    public Page<BlogPost> getAll(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy){
        return blogPostService.getAll(page,size,sortBy);
    }
    @GetMapping("/{id}")
    public BlogPost getById(@PathVariable Long id){
        return blogPostService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost create (@RequestParam BlogPostPayload payload){
        return blogPostService.create(payload);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        blogPostService.delete(id);
    }
}
