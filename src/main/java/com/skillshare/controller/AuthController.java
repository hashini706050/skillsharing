package com.skillshare.controller;


public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        try {
            log.debug("Login attempt for email: {}", request.email());
            AuthResponse response = authService.login(request.email(), request.password());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Login failed for email: {}", request.email(), e);
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }
    
}
