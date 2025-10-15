package pasquale.alberico.bloggingData.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pasquale.alberico.bloggingData.repositories.AuthorRepository;
import pasquale.alberico.bloggingData.repositories.BlogPostRepository;
import pasquale.alberico.bloggingData.entities.Author;
import pasquale.alberico.bloggingData.entities.BlogPost;
import pasquale.alberico.bloggingData.payloads.BlogPostPayload;

import java.util.NoSuchElementException;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AuthorRepository authorRepository;
     public Page<BlogPost> getAll(int page, int size, String sortBy){
         Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
         return blogPostRepository.findAll(pageable);
     }
     public BlogPost getById(Long id) {
         return blogPostRepository.findById(id).orElseThrow(()-> new NoSuchElementException("BlogPost non trovato con id"+ id));
     }

     public BlogPost create(BlogPostPayload payload) {
         //controllo del contenuto
         if(payload.getContenuto() == null || payload.getContenuto().isEmpty()){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "il contenuto non può essere vuoto");
         }

         // Recupero autore
             Author author= authorRepository.findById(payload.getAuthorId()).orElseThrow(()-> new NoSuchElementException("Autore non trovato"));

         //cro il blogpost
             BlogPost post= new BlogPost();
             post.setTitolo(payload.getTitolo());
             post.setContenuto(payload.getContenuto());
             post.setCategoria(payload.getCategoria());
             post.setTempoDiLettura(payload.getTempoDiLettura());
             post.setCover("https://picsum.photos/200/300");
             post.setAuthor(author);
        //salvo e ritorno
             return blogPostRepository.save(post);
     }
     public void delete(Long id){
         blogPostRepository.deleteById(id);
     }
}
