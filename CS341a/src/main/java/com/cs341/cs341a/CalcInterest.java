public class CalcInterest {

    /**
     * This method calculates the total interest based on loan type, loan amount, and loan duration.
     * There are two types of loans: "Home" and "Property".
     * The method uses the simple interest formula and applies different interest rates
     * depending on the loan amount, loan type, and number of years.
     *
     * @param loanAmount The amount of loan to be taken.
     * @param yearLoan The number of years for the loan.
     * @param loanType The type of loan: 1 for 'Home', 2 for 'Property'.
     * @return The interest rate or -1 in case of invalid input.
     */
    public static double computeLoanInterest(double loanAmount, int yearLoan, int loanType) {
        // Validate inputs
        if (loanAmount <= 0 || yearLoan <= 0 || (loanType != 1 && loanType != 2)) {
            return -1; // Invalid input
        }

        double interestRate = -1;

        // Check for Home loan
        if (loanType == 1) {
            if (loanAmount < 100000) {
                if (yearLoan < 5) {
                    interestRate = 8.0;
                } else if (yearLoan < 10) {
                    interestRate = 6.5;
                } else {
                    interestRate = 5.5;
                }
            } else if (loanAmount <= 500000) {
                if (yearLoan < 10) {
                    interestRate = 6.5;
                } else {
                    interestRate = 5.5;
                }
            } else {
                if (yearLoan >= 11) {
                    interestRate = 5.5;
                } else {
                    interestRate = 6.5;
                }
            }
        }

        // Check for Property loan
        else if (loanType == 2) {
            if (loanAmount < 100000) {
                if (yearLoan < 5) {
                    interestRate = 12.0;
                } else if (yearLoan < 10) {
                    interestRate = 8.5;
                } else {
                    interestRate = 7.0;
                }
            } else if (loanAmount <= 500000) {
                if (yearLoan < 10) {
                    interestRate = 8.5;
                } else {
                    interestRate = 7.0;
                }
            } else {
                if (yearLoan >= 11) {
                    interestRate = 7.0;
                } else {
                    interestRate = 8.5;
                }
            }
        }

        return interestRate;
    }

    public static void main(String[] args) {
        // Test cases from your test plan
        System.out.println(computeLoanInterest(99999, 4, 1)); // Expected: 8.0 (Home loan, < 100k, < 5 years)
        System.out.println(computeLoanInterest(100000, 5, 1)); // Expected: 6.5 (Home loan, 100k, 5 years)
        System.out.println(computeLoanInterest(500001, 11, 1)); // Expected: 5.5 (Home loan, > 500k, >= 11 years)
        System.out.println(computeLoanInterest(-10000, 5, 1)); // Expected: -1 (Invalid loan amount)
        System.out.println(computeLoanInterest(99999, 9, 2)); // Expected: 8.5 (Property loan, < 100k, 5-10 years)
        System.out.println(computeLoanInterest(500000, 10, 2)); // Expected: 8.5 (Property loan, 100k-500k, 5-10 years)
        System.out.println(computeLoanInterest(500001, 11, 2)); // Expected: 7.0 (Property loan, > 500k, >= 11 years)
        System.out.println(computeLoanInterest(200000, 0, 2)); // Expected: -1 (Invalid year)
        System.out.println(computeLoanInterest(0, 5, 1)); // Expected: -1 (Invalid loan amount)
    }
}
