
public class PostController {
    private final PostRepository postRepository;
    

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {



