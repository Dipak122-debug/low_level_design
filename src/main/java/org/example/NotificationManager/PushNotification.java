package org.example.NotificationManager;

public class PushNotification extends NotificationChannel {

    public PushNotification() {
        super(NotificationType.PUSH);
    }

    @Override
    public void sendNotification(String message, String recipient) {
        // In a real system, integrate with push notification providers (FCM, APNs)
        System.out.println("[PUSH] Sending push notification to " + recipient + " with message: " + message);
    }
}
