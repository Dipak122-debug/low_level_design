package org.example.LLDUseCase.splitwise;

import org.example.LLDUseCase.splitwise.enums.SplitType;
import org.example.LLDUseCase.splitwise.models.Expense;
import org.example.LLDUseCase.splitwise.models.Group;
import org.example.LLDUseCase.splitwise.models.Split;
import org.example.LLDUseCase.splitwise.models.User;
import org.example.splitwise.models.*;
import org.example.LLDUseCase.splitwise.services.SplitwiseService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SplitwiseDemo {
    public static void main(String[] args) {
        SplitwiseService service = new SplitwiseService();

        // Create users
        User alice = new User("1", "Alice", "alice@example.com");
        User bob = new User("2", "Bob", "bob@example.com");
        User charlie = new User("3", "Charlie", "charlie@example.com");

        // Add users to service
        service.addUser(alice);
        service.addUser(bob);
        service.addUser(charlie);

        // Create a group
        List<User> groupMembers = Arrays.asList(alice, bob, charlie);
        Group group = service.createGroup("Trip to Vegas", groupMembers);

        // Scenario 1: EQUAL split - Alice pays $300, split equally among 3 people
        System.out.println("\n--- Scenario 1: EQUAL Split ---");
        List<Split> equalSplits = Arrays.asList(
                new Split("1", alice, 100),
                new Split("2", bob, 100),
                new Split("3", charlie, 100)
        );
        Expense expense1 = new Expense("E1", 300, "Hotel", alice, SplitType.EQUAL, equalSplits);
        service.addExpense(group, expense1);

        System.out.println("\nAlice's Balance:");
        printBalances(alice, service.showBalances(alice));

        System.out.println("\nBob's Balance:");
        printBalances(bob, service.showBalances(bob));

        System.out.println("\nCharlie's Balance:");
        printBalances(charlie, service.showBalances(charlie));

        // Scenario 2: PERCENTAGE split - Bob pays $200, 50% Alice, 30% Bob, 20% Charlie
        System.out.println("\n--- Scenario 2: PERCENTAGE Split ---");
        List<Split> percentageSplits = Arrays.asList(
                new Split("4", alice, 100, 50),
                new Split("5", bob, 60, 30),
                new Split("6", charlie, 40, 20)
        );
        Expense expense2 = new Expense("E2", 200, "Dinner", bob, SplitType.PERCENTAGE, percentageSplits);
        service.addExpense(group, expense2);

        System.out.println("\nAlice's Balance:");
        printBalances(alice, service.showBalances(alice));

        System.out.println("\nBob's Balance:");
        printBalances(bob, service.showBalances(bob));

        System.out.println("\nCharlie's Balance:");
        printBalances(charlie, service.showBalances(charlie));

        // Scenario 3: EXACT split - Charlie pays $150, Alice pays $50, Bob pays $75, Charlie pays $25
        System.out.println("\n--- Scenario 3: EXACT Split ---");
        List<Split> exactSplits = Arrays.asList(
                new Split("7", alice, 50),
                new Split("8", bob, 75),
                new Split("9", charlie, 25)
        );
        Expense expense3 = new Expense("E3", 150, "Drinks", charlie, SplitType.EXACT, exactSplits);
        service.addExpense(group, expense3);

        System.out.println("\nAlice's Balance:");
        printBalances(alice, service.showBalances(alice));

        System.out.println("\nBob's Balance:");
        printBalances(bob, service.showBalances(bob));

        System.out.println("\nCharlie's Balance:");
        printBalances(charlie, service.showBalances(charlie));

        // Settle up
        System.out.println("\n--- Settlement ---");
        service.settleUp(bob, alice);
        service.settleUp(charlie, alice);
        service.settleUp(charlie, bob);
    }

    private static void printBalances(User user, Map<User, Double> balances) {
        for (Map.Entry<User, Double> entry : balances.entrySet()) {
            double amount = entry.getValue();
            if (amount > 0) {
                System.out.println(user.getName() + " is owed $" + amount + " by " + entry.getKey().getName());
            } else if (amount < 0) {
                System.out.println(user.getName() + " owes $" + Math.abs(amount) + " to " + entry.getKey().getName());
            }
        }
    }
}

