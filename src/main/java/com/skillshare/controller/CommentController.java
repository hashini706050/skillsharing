package com.skillshare.controller;

import com.skillshare.model.Comment;
import com.skillshare.model.Notification;
import com.skillshare.repository.CommentRepository;
import com.skillshare.repository.NotificationRepository;
import com.skillshare.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository; 
    private final NotificationRepository notificationRepository;

    @GetMapping
    public ResponseEntity<List<Comment>> getComments(@PathVariable String postId) {
        try {
            log.debug("Fetching comments for post: {}", postId);
            List<Comment> comments = commentRepository.findByPostId(postId);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            log.error("Error fetching comments for post: {}", postId, e);
            throw new RuntimeException("Failed to fetch comments", e);
        }
    }

}
