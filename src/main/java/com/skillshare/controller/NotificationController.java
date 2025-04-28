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

    @GetMapping("/unread-count")
    public ResponseEntity<Map<String, Long>> getUnreadCount() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String userId = auth.getName();
            
            long count = notificationRepository.countByUserIdAndRead(userId, false);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (Exception e) {
            log.error("Error fetching unread notification count", e);
            throw new RuntimeException("Failed to fetch unread count", e);
        }
    }
    
}
