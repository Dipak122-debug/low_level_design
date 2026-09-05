package org.example.LLDUseCase.splitwise.strategies;

import org.example.LLDUseCase.splitwise.models.Split;
import org.example.LLDUseCase.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Strategy for splitting expenses based on percentages.
 * Each user's share is determined by their percentage of the total.
 */
public class PercentageSplitStrategy implements SplitStrategy {

    @Override
    public Map<User, Double> calculateSplit(List<Split> splits, double totalAmount) {
        Map<User, Double> splitAmounts = new HashMap<>();

        for (Split split : splits) {
            if (split.getPercentage() == null) {
                throw new IllegalArgumentException("Percentage must be set for percentage split strategy");
            }
            double amount = (split.getPercentage() / 100.0) * totalAmount;
            splitAmounts.put(split.getUser(), amount);
        }

        return splitAmounts;
    }
}

