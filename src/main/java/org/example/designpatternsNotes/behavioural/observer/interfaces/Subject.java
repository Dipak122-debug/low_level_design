package org.example.designpatternsNotes.behavioural.observer.interfaces;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
