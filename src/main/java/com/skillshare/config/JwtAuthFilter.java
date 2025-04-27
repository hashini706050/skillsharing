package com.skillshare.config;


public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtAuthFilter(@Lazy JwtService jwtService) {
        this.jwtService = jwtService;
    }
    
}
