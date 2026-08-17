package org.example.DesignpatternsNotes.behavioural.observer.interfaces;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
