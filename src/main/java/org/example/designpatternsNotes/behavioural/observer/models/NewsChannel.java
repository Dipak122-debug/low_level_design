package org.example.designpatternsNotes.behavioural.observer.models;

import org.example.designpatternsNotes.behavioural.observer.interfaces.Observer;

public class NewsChannel implements Observer {
    private final String channelName;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String news) {
        System.out.println(channelName + " broadcasting: " + news);
    }
}
