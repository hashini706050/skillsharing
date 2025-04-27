public class JwtService {
    private final JwtConfig jwtConfig;

    private SecretKey getSigningKey() {
        String secretKey = jwtConfig.getSecret();
        if (secretKey == null || secretKey.trim().isEmpty()) {
            throw new IllegalStateException("JWT secret key is not configured");
        }
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    
}
