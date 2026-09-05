package org.example.LLDUseCase.splitwise.strategies;

import org.example.LLDUseCase.splitwise.models.Split;
import org.example.LLDUseCase.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Strategy for splitting expenses using exact amounts.
 * Each user's share is specified exactly without calculation.
 */
public class ExactSplitStrategy implements SplitStrategy {

    @Override
    public Map<User, Double> calculateSplit(List<Split> splits, double totalAmount) {
        Map<User, Double> splitAmounts = new HashMap<>();

        for (Split split : splits) {
            splitAmounts.put(split.getUser(), split.getAmount());
        }

        return splitAmounts;
    }
}

