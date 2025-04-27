

public class UserRepository {
    public interface UserRepository extends MongoRepository<User, String> {
        Optional<User> findByEmail(String email);
        boolean existsByEmail(String email);
    
        List<User> findAllByIdIn(List<String> ids);
    }
}
