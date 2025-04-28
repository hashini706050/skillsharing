public class Notification {
    @Id
    private String id;
    
    @Field("user_id")
    private String userId;
    
    private String type;
    private String message;
    
    @Field("action_user_id")
    private String actionUserId;
    
    @Field("post_id")
    private String postId;
    
    @Field("comment_id")
    private String commentId;
    
    private boolean read;
    
    @Field("created_at")
    private Instant createdAt;
}
