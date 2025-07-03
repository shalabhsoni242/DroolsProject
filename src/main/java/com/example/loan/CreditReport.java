package com.example.loan;

public class CreditReport {
    private int creditScore;
    private double totalExistingDebt; // Total outstanding debt
    private int numberOfMissedPayments;

    // Constructor
    public CreditReport(int creditScore, double totalExistingDebt, int numberOfMissedPayments) {
        this.creditScore = creditScore;
        this.totalExistingDebt = totalExistingDebt;
        this.numberOfMissedPayments = numberOfMissedPayments;
    }

    //Getters & Setters
     public int getCreditScore() {
        return this.creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public double getTotalExistingDebt() {
        return this.totalExistingDebt;
    }

    public void setTotalExistingDebt(double totalExistingDebt) {
        this.totalExistingDebt = totalExistingDebt;
    }

    public int getNumberOfMissedPayments() {
        return this.numberOfMissedPayments;
    }

    public void setNumberOfMissedPayments(int numberOfMissedPayments) {
        this.numberOfMissedPayments = numberOfMissedPayments;
    }

    //ToString
    @Override
    public String toString(){
        return "CreditReport{" +
               "creditScore=" + creditScore +
               ", totalExistingDebt=" + totalExistingDebt +
               ", numberOfMissedPayments=" + numberOfMissedPayments +
               '}';
    }

}
