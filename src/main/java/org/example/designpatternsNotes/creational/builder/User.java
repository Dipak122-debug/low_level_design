package org.example.designpatternsNotes.creational.builder;

/*
The Builder Design Pattern is a creational design pattern used to construct complex objects step-by-step.
It separates the construction logic of an object from its actual representation, allowing you to
create different variations of the same object using the same construction process.

The Problem It Solves

Imagine a User class with multiple fields.

Without the Builder pattern,

your options are messy:

Telescoping Constructors: Multiple constructors with varying numbers of arguments. It becomes incredibly easy to pass arguments in the wrong order.

Setters: Creating an empty object and calling setters. This makes the object mutable, breaking thread safety and leaving it in an incomplete,
invalid state during construction.
*/
public class User {
    // All fields are final to ensure immutability
    private final String firstName; // Mandatory
    private final String lastName;  // Mandatory
    private final int age;          // Optional
    private final String phone;     // Optional

    // Private constructor so only the Builder can instantiate it
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
    }

    // Getters (No Setters to keep it immutable)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }

    // Static Inner Builder Class
    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;

        // Constructor enforces mandatory fields
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Setter-like methods that return 'this' for method chaining
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        // The final build method that constructs the User object
        public User build() {
            // Validation logic can be placed here before object creation
            return new User(this);
        }
    }
}