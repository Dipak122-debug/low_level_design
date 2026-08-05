package org.example.NotificationManager;

class PushNotification implements Notification {

    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending push notification to " + recipient + " with message: " + message);
    }
}
