package com.skillshare.controller;

import java.time.Instant;
import java.util.List;

import javax.management.Notification;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillshare.model.Like;
import com.skillshare.repository.LikeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/posts/{postId}/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final NotificationRepository notificationRepository;

    @GetMapping
    public ResponseEntity<List<Like>> getLikes(@PathVariable String postId) {
        try {
            log.debug("Fetching likes for post: {}", postId);
            List<Like> likes = likeRepository.findByPostId(postId);
            return ResponseEntity.ok(likes);
        } catch (Exception e) {
            log.error("Error fetching likes for post: {}", postId, e);
            throw new RuntimeException("Failed to fetch likes", e);
        }
    }

    @PostMapping
public ResponseEntity<Like> addLike(@PathVariable String postId) {
    
}

}
