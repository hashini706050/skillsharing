public class NotificationController {
    private final NotificationRepository notificationRepository;

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications(
        @RequestParam(required = false) Boolean unreadOnly
    ) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String userId = auth.getName();
            
            List<Notification> notifications = unreadOnly != null && unreadOnly
                ? notificationRepository.findByUserIdAndReadOrderByCreatedAtDesc(userId, false)
                : notificationRepository.findByUserIdOrderByCreatedAtDesc(userId);
                
            return ResponseEntity.ok(notifications);
        } catch (Exception e) {
            log.error("Error fetching notifications", e);
            throw new RuntimeException("Failed to fetch notifications", e);
        }
    }
    
}
