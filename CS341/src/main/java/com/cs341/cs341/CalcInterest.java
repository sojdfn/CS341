import java.util.Scanner;


public class CalcInterest {
    
    // Method to compute loan interest
    public double computeLoanInterest(int loanType, double loanAmount, int yearLoan) {
        double interestRate = -1; // Default error value

        // Loan Type 1: Home
        if (loanType == 1) {
            if (loanAmount >= 100000) if (loanAmount >= 100000 && loanAmount <= 500000) {
                interestRate = 6.5;
            } else if (loanAmount > 500000 && yearLoan >= 11) {
                interestRate = 5.5;
            } else {
                if (yearLoan < 5) {
                    interestRate = 8.0;
                } else if (yearLoan >= 5 && yearLoan < 10) {
                    interestRate = 6.5;
                } else if (yearLoan >= 11) {
                    interestRate = 5.5;
                }
            }
        }
        // Loan Type 2: Property
        else if (loanType == 2) {
            if (loanAmount < 100000) {
                if (yearLoan < 5) {
                    interestRate = 12.0;
                } else if (yearLoan >= 5 && yearLoan < 10) {
                    interestRate = 8.5;
                } else if (yearLoan >= 11) {
                    interestRate = 7.0;
                }
            } else if (loanAmount >= 100000 && loanAmount <= 500000) {
                interestRate = 8.5;
            } else if (loanAmount > 500000 && yearLoan >= 11) {
                interestRate = 7.0;
            }
        }
        return interestRate;
    }

    public static void main(String[] args) {
        CalcInterest calc = new CalcInterest();
        
        // Test Case 1: Home Loan, loanAmount = 99,999, yearLoan = 4
        double result1 = calc.computeLoanInterest(1, 99999, 4);
        System.out.println("Test Case 1 (Expected 8%): " + result1 + "%");
        
        // Test Case 2: Home Loan, loanAmount = 100,000, yearLoan = 5
        double result2 = calc.computeLoanInterest(1, 100000, 5);
        System.out.println("Test Case 2 (Expected 6.5%): " + result2 + "%");
        
        // Test Case 3: Property Loan, loanAmount = 99,999, yearLoan = 9
        double result3 = calc.computeLoanInterest(2, 99999, 9);
        System.out.println("Test Case 3 (Expected 8.5%): " + result3 + "%");
        
        // Add additional test cases based on your boundary analysis and equivalence partitioning
    }
}
