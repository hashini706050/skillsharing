import java.time.Instant;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String userId = auth.getName();
            
            log.debug("Creating post for user: {}", userId);
            
            Post newPost = Post.builder()
                .userId(userId)
                .title(post.getTitle())
                .content(post.getContent())
                .media(post.getMedia())
                .type(post.getType())
                .progressTemplate(post.getProgressTemplate())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
                
            Post savedPost = postRepository.save(newPost);
            log.debug("Post created successfully with id: {}", savedPost.getId());
            
            return ResponseEntity.ok(savedPost);
        } catch (Exception e) {
            log.error("Error creating post", e);
            throw new RuntimeException("Failed to create post", e);
        }
    }




