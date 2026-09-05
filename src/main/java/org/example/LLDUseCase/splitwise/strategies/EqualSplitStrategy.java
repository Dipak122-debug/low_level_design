package org.example.LLDUseCase.splitwise.strategies;

import org.example.LLDUseCase.splitwise.models.Split;
import org.example.LLDUseCase.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Strategy for splitting expenses equally among all users.
 * Each user pays an equal share of the total amount.
 */
public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public Map<User, Double> calculateSplit(List<Split> splits, double totalAmount) {
        Map<User, Double> splitAmounts = new HashMap<>();
        double equalAmount = totalAmount / splits.size();

        for (Split split : splits) {
            splitAmounts.put(split.getUser(), equalAmount);
        }

        return splitAmounts;
    }
}

