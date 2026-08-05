package org.example.NotificationManager;



class EmailNotification implements Notification {

    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending email to " + recipient + " with message: " + message);
    }
}
