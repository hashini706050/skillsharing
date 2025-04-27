import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.skillshare.model.Post;

public class PostController {
    private final PostRepository postRepository;
    

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
         try {
            log.debug("Fetching all posts");
            List<Post> posts = postRepository.findAll();
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            log.error("Error fetching posts", e);
            throw new RuntimeException("Failed to fetch posts", e);
        }
    }




