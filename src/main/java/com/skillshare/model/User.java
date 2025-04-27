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
    
}
