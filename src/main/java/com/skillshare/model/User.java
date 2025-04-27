public class User {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String email;
    
    private String password;
    
    @Field("first_name")
    private String firstName;
    
    @Field("last_name")
    private String lastName;
    
    private String address;
    
    private String birthday;

    @Field("avatar_url")
    private String avatarUrl;
    
    private String bio;
    
    @Builder.Default
    @Field("following_ids")
    private List<String> followingIds = new ArrayList<>();
    
    @Builder.Default
    @Field("follower_ids")
    private List<String> followerIds = new ArrayList<>();
    
    @Field("created_at")
    private Instant createdAt;
    
    @Field("updated_at")
    private Instant updatedAt;

}
