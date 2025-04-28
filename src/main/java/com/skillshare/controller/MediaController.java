package com.skillshare.controller;


public class MediaController {
    private final MediaService mediaService;
    
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MediaItem> uploadMedia(
        @RequestParam("file") MultipartFile file,
        @RequestParam(value = "description", required = false) String description