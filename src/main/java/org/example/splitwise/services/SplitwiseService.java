package org.example.splitwise.services;

import org.example.splitwise.enums.SplitType;
import org.example.splitwise.models.*;
import org.example.splitwise.strategies.SplitStrategy;
import org.example.splitwise.strategies.SplitStrategyFactory;

import java.util.*;

public class SplitwiseService {
    private List<User> users;
    private List<Group> groups;
    private Map<User, BalanceSheet> balanceSheets;

    public SplitwiseService() {
        this.users = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.balanceSheets = new HashMap<>();
    }

    public void addUser(User user) {
        users.add(user);
        balanceSheets.put(user, new BalanceSheet(user.getId(), user));
    }

    public Group createGroup(String name, List<User> members) {
        String groupId = UUID.randomUUID().toString();
        Group group = new Group(groupId, name);
        for (User member : members) {
            group.addMember(member);
        }
        groups.add(group);
        return group;
    }

    public void addExpense(Group group, Expense expense) {
        group.addExpense(expense);
        settleExpense(expense, group);
    }

    private void settleExpense(Expense expense, Group group) {
        User paidBy = expense.getPaidBy();
        List<Split> splits = expense.getSplits();
        SplitType splitType = expense.getSplitType();
        double totalAmount = expense.getAmount();

        Map<User, Double> splitAmounts = calculateSplits(splits, splitType, totalAmount);

        for (Map.Entry<User, Double> entry : splitAmounts.entrySet()) {
            User user = entry.getKey();
            double amount = entry.getValue();

            if (!user.equals(paidBy)) {
                // user owes paidBy
                BalanceSheet userBalanceSheet = balanceSheets.get(user);
                userBalanceSheet.addBalance(paidBy, -amount);

                // paidBy is owed by user
                BalanceSheet paidByBalanceSheet = balanceSheets.get(paidBy);
                paidByBalanceSheet.addBalance(user, amount);
            }
        }
    }

    private Map<User, Double> calculateSplits(List<Split> splits, SplitType splitType, double totalAmount) {
        // Use the Strategy pattern - get the appropriate strategy based on split type
        SplitStrategy strategy = SplitStrategyFactory.getStrategy(splitType);
        return strategy.calculateSplit(splits, totalAmount);
    }

    public BalanceSheet getBalanceSheet(User user) {
        return balanceSheets.get(user);
    }

    public double getBalanceWithUser(User user1, User user2) {
        BalanceSheet balanceSheet = balanceSheets.get(user1);
        return balanceSheet.showBalanceWithUser(user2);
    }

    public Map<User, Double> showBalances(User user) {
        BalanceSheet balanceSheet = balanceSheets.get(user);
        return balanceSheet.showBalances();
    }

    public double showBalanceWithUser(User user1, User user2) {
        return getBalanceWithUser(user1, user2);
    }

    public void settleUp(User user1, User user2) {
        BalanceSheet balanceSheet1 = balanceSheets.get(user1);
        BalanceSheet balanceSheet2 = balanceSheets.get(user2);

        double amount = balanceSheet1.showBalanceWithUser(user2);

        if (amount > 0) {
            // user1 is owed by user2, so user2 pays user1
            balanceSheet1.setBalance(user2, 0);
            balanceSheet2.setBalance(user1, 0);
            System.out.println(user2.getName() + " pays $" + amount + " to " + user1.getName());
        } else if (amount < 0) {
            // user1 owes user2
            balanceSheet1.setBalance(user2, 0);
            balanceSheet2.setBalance(user1, 0);
            System.out.println(user1.getName() + " pays $" + Math.abs(amount) + " to " + user2.getName());
        } else {
            System.out.println("No balance between " + user1.getName() + " and " + user2.getName());
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Map<User, BalanceSheet> getBalanceSheets() {
        return balanceSheets;
    }
}

