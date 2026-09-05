package org.example.LLDUseCase.splitwise.strategies;

import org.example.LLDUseCase.splitwise.enums.SplitType;

/**
 * Factory class for creating appropriate SplitStrategy based on SplitType.
 * This factory uses the Strategy pattern to provide the correct split calculation
 * strategy without exposing the client to the concrete implementations.
 */
public class SplitStrategyFactory {

    /**
     * Get the appropriate strategy for the given split type
     * @param splitType The type of split (EQUAL, PERCENTAGE, EXACT)
     * @return The corresponding SplitStrategy implementation
     * @throws IllegalArgumentException if split type is not supported
     */
    public static SplitStrategy getStrategy(SplitType splitType) {
        if (splitType == null) {
            throw new IllegalArgumentException("Split type cannot be null");
        }

        switch (splitType) {
            case EQUAL:
                return new EqualSplitStrategy();
            case PERCENTAGE:
                return new PercentageSplitStrategy();
            case EXACT:
                return new ExactSplitStrategy();
            default:
                throw new IllegalArgumentException("Unsupported split type: " + splitType);
        }
    }
}

