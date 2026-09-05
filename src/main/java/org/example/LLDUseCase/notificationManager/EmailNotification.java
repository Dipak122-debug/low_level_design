package org.example.LLDUseCase.notificationManager;

public class EmailNotification extends NotificationChannel {

    public EmailNotification() {
        super(NotificationType.EMAIL);
    }

    @Override
    public void sendNotification(String message, String recipient) {
        // In a real system, integrate with an SMTP provider or email gateway
        System.out.println("[EMAIL] Sending email to " + recipient + " with message: " + message);
    }
}
