package org.example.DesignpatternsNotes.Observer.models;

import java.util.ArrayList;
import java.util.List;
import org.example.DesignpatternsNotes.Observer.interfaces.Observer;
import org.example.DesignpatternsNotes.Observer.interfaces.Subject;

public class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String latestNews;

    public void setNews(String news) {
        this.latestNews = news;
        notifyObservers(); // Automatically notify upon state change
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestNews);
        }
    }
}
