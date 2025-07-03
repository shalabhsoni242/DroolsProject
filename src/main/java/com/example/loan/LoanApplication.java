package com.example.loan;

public class LoanApplication {
    private double loanAmt;
    private int loanTermMonths;
    private boolean approved;
    private String rejectionReason;
    private boolean coSignerRequired;

    //Constructor
    public LoanApplication(double loanAmt, int loanTermMonths) {
        this.loanAmt = loanAmt;
        this.loanTermMonths = loanTermMonths;
        this.approved = false; // Default to not approved
        this.rejectionReason = "Not evaluated";
        this.coSignerRequired = false;
    }

    //Getters & Setters
    public double getLoanAmt() {
        return this.loanAmt;
    }

    public void setLoanAmt(double loanAmt) {
        this.loanAmt = loanAmt;
    }

    public int getLoanTermMonths() {
        return this.loanTermMonths;
    }

    public void setLoanTermMonths(int loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getRejectionReason() {
        return this.rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public boolean isCoSignerRequired() {
        return this.coSignerRequired;
    }

    public void setCoSignerRequired(boolean coSignerRequired) {
        this.coSignerRequired = coSignerRequired;
    }

     @Override
    public String toString() {
        return "LoanApplication{" +
               "loanAmount=" + loanAmt +
               ", loanTermMonths=" + loanTermMonths +
               ", approved=" + approved +
               ", rejectionReason='" + rejectionReason + '\'' +
               ", coSignerRequired=" + coSignerRequired +
               '}';
    }
}
