package com.skillshare.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Comment {
    @Id
    private String id;
    
    @Field("post_id")
    private String postId;
    
    @Field("user_id")
    private String userId;
    
    private String content;
    
    @Field("created_at")
    private Instant createdAt;
    
    @Field("updated_at")
    private Instant updatedAt;
}
