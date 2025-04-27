package com.skillshare.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Post {
   
    @Id
    private String id;
    
    @Field("user_id")
    private String userId;
    
    private String title;
    private String content;
    
    @Builder.Default
    private List<MediaItem> media = new ArrayList<>();
    
    private String type; 



}
