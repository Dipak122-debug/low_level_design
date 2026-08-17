package org.example.DesignpatternsNotes.creational.builder;

public class Main {
    public static void main(String[] args) {
        // Constructing a user step-by-step
        User user = new User.UserBuilder("John", "Doe") // Mandatory fields
                .age(30)                               // Optional field
                .phone("123-456-7890")                 // Optional field
                .build();                              // Returns the final User instance

        System.out.println("User created: " + user.getFirstName() + " " + user.getLastName());
    }
}
