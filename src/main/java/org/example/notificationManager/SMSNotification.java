package org.example.notificationManager;

public class SMSNotification extends NotificationChannel {

    public SMSNotification() {
        super(NotificationType.SMS);
    }

    @Override
    public void sendNotification(String message, String recipient){
        // In a real system, integrate with an SMS gateway
        System.out.println("[SMS] Sending SMS to " + recipient + " with message: " + message);
    }
}


