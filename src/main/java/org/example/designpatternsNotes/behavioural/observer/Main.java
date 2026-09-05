package org.example.designpatternsNotes.behavioural.observer;

import org.example.designpatternsNotes.behavioural.observer.models.NewsAgency;
import org.example.designpatternsNotes.behavioural.observer.models.NewsChannel;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel bbc = new NewsChannel("BBC");
        NewsChannel cnn = new NewsChannel("CNN");

        // Registering observers
        agency.addObserver(bbc);
        agency.addObserver(cnn);

        // State changes automatically trigger updates
        agency.setNews("Breaking: Observer Pattern works perfectly!");

        // Unregistering an observer
        agency.removeObserver(bbc);
        agency.setNews("Update: Second headline broadcasted.");
    }
}
