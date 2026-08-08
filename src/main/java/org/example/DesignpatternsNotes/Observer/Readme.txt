Observer Design Pattern
- The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency between objects, so that when one object (the subject) changes state,
all its dependents (observers) are notified and updated automatically. This pattern is commonly used in scenarios where an object needs to maintain consistency across
multiple dependent objects without tightly coupling them.

Subject: The subject is the object that holds the state and notifies observers of any changes. It maintains a list of observers and provides methods to attach, detach, and notify them.
Observer: The observer is an interface or abstract class that defines the update method, which is called by the subject when its state changes. Concrete observers implement this interface and define their own update behavior.
Key Components:
1. Subject: The object that maintains a list of observers and notifies them of state changes
2. Observer: The interface or abstract class that defines the update method
3. ConcreteSubject: A concrete implementation of the subject that holds the state and implements the methods
4. ConcreteObserver: A concrete implementation of the observer that defines its own update behavior
Example Use Case:
Consider a weather monitoring application where multiple display elements (observers) need to be updated whenever the weather data (subject) changes. The weather data object maintains a list of display elements and notifies them whenever the weather data is updated. Each display element implements the observer interface and updates its display accordingly
when notified of changes in the weather data.
