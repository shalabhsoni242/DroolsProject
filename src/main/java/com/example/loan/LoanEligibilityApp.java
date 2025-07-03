package com.example.loan;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class LoanEligibilityApp {

    public static void main(String[] args) {
        // 1. Get the KieServices instance
        KieServices ks = KieServices.Factory.get();

        // 2. Load the KieContainer (which contains your KJAR and rules)
        // By default, it looks for kmodule.xml in src/main/resources/META-INF
        // For simple projects, Drools can auto-build a default one.
        // If you don't have kmodule.xml, Drools will compile your DRL files automatically.
        KieContainer kContainer = ks.getKieClasspathContainer();

        // 3. Create a KieSession
        // A KieSession is the runtime component where you insert facts and fire rules.
        // If you have kmodule.xml, specify the session name from there. 
        // Otherwise, it will pick up default KieBase and KieSession.
        KieSession kSession = kContainer.newKieSession("ksession-rules"); // "ksession-rules" is the default session name if no kmodule.xml
        //KieSession kSession = kContainer.newKieSession();

        try {
            // --- Scenario 1: Reject - Low Credit Score ---
            System.out.println("\n--- Scenario 1: Reject - Low Credit Score ---");
            Applicant applicant1 = new Applicant("Alice Smith", 30, 60000, 5, "Employed");
            CreditReport creditReport1 = new CreditReport(550, 5000, 1); // Credit score below 600
            LoanApplication loanApplication1 = new LoanApplication(25000, 36);

            kSession.insert(applicant1);
            kSession.insert(creditReport1);
            kSession.insert(loanApplication1);

            kSession.fireAllRules(); // Execute all applicable rules

            System.out.println("Applicant 1 Loan Status: " + (loanApplication1.isApproved() ? "Approved" : "Rejected"));
            System.out.println("Reason: " + loanApplication1.getRejectionReason());
            System.out.println("Co-signer Required: " + loanApplication1.isCoSignerRequired());
            kSession.delete(kSession.getFactHandle(applicant1)); // Clean up facts for next scenario
            kSession.delete(kSession.getFactHandle(creditReport1));
            kSession.delete(kSession.getFactHandle(loanApplication1));


            // --- Scenario 2: Reject - Income vs Debt ---
            System.out.println("\n--- Scenario 2: Reject - Income vs Debt ---");
            Applicant applicant2 = new Applicant("Bob Johnson", 45, 25000, 10, "Employed"); // Low income
            CreditReport creditReport2 = new CreditReport(700, 15000, 0); // High debt
            LoanApplication loanApplication2 = new LoanApplication(30000, 48);

            kSession.insert(applicant2);
            kSession.insert(creditReport2);
            kSession.insert(loanApplication2);

            kSession.fireAllRules();

            System.out.println("Applicant 2 Loan Status: " + (loanApplication2.isApproved() ? "Approved" : "Rejected"));
            System.out.println("Reason: " + loanApplication2.getRejectionReason());
            System.out.println("Co-signer Required: " + loanApplication2.isCoSignerRequired());
            kSession.delete(kSession.getFactHandle(applicant2));
            kSession.delete(kSession.getFactHandle(creditReport2));
            kSession.delete(kSession.getFactHandle(loanApplication2));


            // --- Scenario 3: Co-signer Required ---
            System.out.println("\n--- Scenario 3: Co-signer Required ---");
            Applicant applicant3 = new Applicant("Charlie Brown", 22, 40000, 0, "Employed"); // Less than 1 year employed
            CreditReport creditReport3 = new CreditReport(680, 2000, 0);
            LoanApplication loanApplication3 = new LoanApplication(10000, 24);

            kSession.insert(applicant3);
            kSession.insert(creditReport3);
            kSession.insert(loanApplication3);

            kSession.fireAllRules();

            System.out.println("Applicant 3 Loan Status: " + (loanApplication3.isApproved() ? "Approved" : "Rejected"));
            System.out.println("Reason: " + loanApplication3.getRejectionReason());
            System.out.println("Co-signer Required: " + loanApplication3.isCoSignerRequired());
            kSession.delete(kSession.getFactHandle(applicant3));
            kSession.delete(kSession.getFactHandle(creditReport3));
            kSession.delete(kSession.getFactHandle(loanApplication3));


            // --- Scenario 4: Approved ---
            System.out.println("\n--- Scenario 4: Approved ---");
            Applicant applicant4 = new Applicant("Diana Prince", 35, 75000, 7, "Employed");
            CreditReport creditReport4 = new CreditReport(750, 8000, 0);
            LoanApplication loanApplication4 = new LoanApplication(50000, 60);

            kSession.insert(applicant4);
            kSession.insert(creditReport4);
            kSession.insert(loanApplication4);

            kSession.fireAllRules();

            System.out.println("Applicant 4 Loan Status: " + (loanApplication4.isApproved() ? "Approved" : "Rejected"));
            System.out.println("Reason: " + loanApplication4.getRejectionReason());
            System.out.println("Co-signer Required: " + loanApplication4.isCoSignerRequired());
            kSession.delete(kSession.getFactHandle(applicant4));
            kSession.delete(kSession.getFactHandle(creditReport4));
            kSession.delete(kSession.getFactHandle(loanApplication4));


        } finally {
            // 4. Dispose the KieSession when done to release resources
            if (kSession != null) {
                kSession.dispose();
            }
        }
    }
}