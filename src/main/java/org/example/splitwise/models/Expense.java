package org.example.splitwise.models;

import org.example.splitwise.enums.SplitType;
import java.util.List;

public class Expense {
    private String id;
    private double amount;
    private String description;
    private User paidBy;
    private SplitType splitType;
    private List<Split> splits;

    public Expense(String id, double amount, String description, User paidBy, SplitType splitType, List<Split> splits) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splits = splits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", paidBy=" + paidBy +
                ", splitType=" + splitType +
                ", splits=" + splits +
                '}';
    }
}

