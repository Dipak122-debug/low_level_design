package org.example.designpatternsNotes.behavioural.observer.models;

import java.util.ArrayList;
import java.util.List;
import org.example.designpatternsNotes.behavioural.observer.interfaces.Observer;
import org.example.designpatternsNotes.behavioural.observer.interfaces.Subject;

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
