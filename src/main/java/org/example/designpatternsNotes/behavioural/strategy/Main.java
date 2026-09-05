package org.example.designpatternsNotes.behavioural.strategy;

import org.example.designpatternsNotes.behavioural.strategy.models.CreditCardStrategy;
import org.example.designpatternsNotes.behavioural.strategy.models.CryptoPaymentStrategy;
import org.example.designpatternsNotes.behavioural.strategy.models.ShoppingCart;

public class Main {

    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();

        // Dynamically swapping strategies based on runtime conditions
        cart.setPaymentStrategy(new CreditCardStrategy());
        cart.checkout(150);

        cart.setPaymentStrategy(new CryptoPaymentStrategy());
        cart.checkout(450);
    }
}
