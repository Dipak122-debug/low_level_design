package org.example.DesignpatternsNotes.Observer.models;

import org.example.DesignpatternsNotes.Observer.interfaces.Observer;

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
