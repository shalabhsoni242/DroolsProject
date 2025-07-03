package com.example.loan;

public class Applicant {
    private String name;
    private int age;
    private double annualIncome;
    private int yearsEmployed; // Years in current job
    private String employmentStatus;// Employed/Self-Employed/Unemployed

    //Constructor
    public Applicant(String name, int age, double annualIncome, int yearsEmployed, String employmentStatus){
        this.name = name;
        this.age = age;
        this.annualIncome = annualIncome;
        this.yearsEmployed = yearsEmployed;
        this.employmentStatus = employmentStatus;
    }

    //Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAnnualIncome() {
        return this.annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getYearsEmployed() {
        return this.yearsEmployed;
    }

    public void setYearsEmployed(int yearsEmployed) {
        this.yearsEmployed = yearsEmployed;
    }

    public String getEmploymentStatus() {
        return this.employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    @Override
    public String toString(){
        return "Applicant{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", annualIncome=" + annualIncome +
               ", yearsEmployed=" + yearsEmployed +
               ", employmentStatus='" + employmentStatus + '\'' +
               '}';
    }
    
}
