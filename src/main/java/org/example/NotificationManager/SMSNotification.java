package org.example.NotificationManager;
class SMSNotification implements Notification {

    @Override
    public void sendNotification(String message, String recipient){
        System.out.println("Sending SMS to " + recipient + " with message: " + message);
    }
}


