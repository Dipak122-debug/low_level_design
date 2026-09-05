package org.example.notificationManager;

/**
 * Notification interface used by concrete notification channels.
 */
public interface Notification {
    /**
     * Send a notification message to a recipient.
     * @param message human readable message or payload
     * @param recipient destination (email, phone, device id etc.)
     */
    void sendNotification(String message, String recipient);
}
