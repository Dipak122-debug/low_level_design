package org.example.Splitwise.strategies;

import org.example.Splitwise.models.Split;
import org.example.Splitwise.models.User;

import java.util.List;
import java.util.Map;

/**
 * Strategy interface for calculating how expenses are split among users.
 */
public interface SplitStrategy {
    /**
     * Calculate the split amounts for each user
     *
     * @param splits      List of Split objects containing user information
     * @param totalAmount Total amount to be split
     * @return Map of User to the amount they should pay
     */
    Map<User, Double> calculateSplit(List<Split> splits, double totalAmount);
}

