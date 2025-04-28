package com.skillshare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class MediaController {
    private final MediaService mediaService;
    
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MediaItem> uploadMedia(
        @RequestParam("file") MultipartFile file,
        @RequestParam(value = "description", required = false) String description
        ) {
            try {
                log.info("Uploading media file: {}", file.getOriginalFilename());
                MediaItem savedMedia = mediaService.saveMedia(file, description);
                return ResponseEntity.ok(savedMedia);
            } catch (Exception e) {
                log.error("Error uploading media", e);
                throw new RuntimeException("Failed to upload media: " + e.getMessage());
            }
        }

        @GetMapping("/{id}")
    public ResponseEntity<byte[]> getMedia(@PathVariable String id) {
        try {
            MediaItem media = mediaService.getMedia(id);
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(media.getContentType()))
                .body(media.getData());
        } catch (Exception e) {
            log.error("Error retrieving media with id: {}", id, e);
            throw new RuntimeException("Failed to retrieve media: " + e.getMessage());
        }
    }
}
        