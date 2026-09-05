package org.example.LLDUseCase.splitwise.strategies;

import org.example.LLDUseCase.splitwise.models.Split;
import org.example.LLDUseCase.splitwise.models.User;

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

