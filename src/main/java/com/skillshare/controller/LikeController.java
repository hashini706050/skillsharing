package com.skillshare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
       
    }
}
