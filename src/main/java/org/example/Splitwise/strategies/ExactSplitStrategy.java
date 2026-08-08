package org.example.Splitwise.strategies;

import org.example.Splitwise.models.Split;
import org.example.Splitwise.models.User;

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

