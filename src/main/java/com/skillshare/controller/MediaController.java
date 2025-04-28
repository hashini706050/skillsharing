package com.skillshare.controller;


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
        