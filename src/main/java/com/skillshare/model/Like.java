package com.skillshare.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    private String id;
    
    @Field("post_id")
    private String postId;
    
    @Field("user_id")
    private String userId;
    
    @Field("created_at")
    private Instant createdAt;
}
}
