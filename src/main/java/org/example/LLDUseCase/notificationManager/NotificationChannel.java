package org.example.LLDUseCase.notificationManager;

/**
 * Base class for notification channels. Concrete channels implement sendNotification.
 */
public abstract class NotificationChannel implements Notification {
    private final NotificationType type;

    protected NotificationChannel(NotificationType type) {
        this.type = type;
    }

    public NotificationType getType() {
        return type;
    }
}

