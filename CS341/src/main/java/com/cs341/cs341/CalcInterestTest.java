package com.cs341.cs341;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class CalcInterestTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private CalcInterest calc = new CalcInterest();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // Improved test of the main method
    @Test
    @DisplayName("Test the main method output")
    public void testMain() {
        CalcInterest.main(null);

        String expectedOutput = "Test Case 1 (Expected 8%): 8.0%\n" +
                                "Test Case 2 (Expected 6.5%): 6.5%\n" +
                                "Test Case 3 (Expected 8.5%): 8.5%\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    // Boundary Testing
    @Test
    @DisplayName("Boundary Test - Home Loan just below 100,000")
    public void testBoundaryHomeLoanJustBelow100k() {
        assertEquals(8.0, calc.computeLoanInterest(1, 99999, 4), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Home Loan exactly 100,000")
    public void testBoundaryHomeLoanExactly100k() {
        assertEquals(6.5, calc.computeLoanInterest(1, 100000, 5), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Home Loan just above 100,000")
    public void testBoundaryHomeLoanJustAbove100k() {
        assertEquals(6.5, calc.computeLoanInterest(1, 100001, 5), 0.001);
    }
  
    @Test
    @DisplayName("Boundary Test - Home Loan at minimum loan amount")
    public void testBoundaryHomeLoanMinAmount() {
        assertEquals(8.0, calc.computeLoanInterest(1, 0, 4), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Home Loan at maximum loan amount")
    public void testBoundaryHomeLoanMaxAmount() {
        assertEquals(5.0, calc.computeLoanInterest(1, Integer.MAX_VALUE, 30), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Home Loan at yearLoan = 0")
    public void testBoundaryYearLoanZero() {
        assertEquals(0.0, calc.computeLoanInterest(1, 100000, 0), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Home Loan at yearLoan = 1")
    public void testBoundaryYearLoanOne() {
        assertEquals(8.0, calc.computeLoanInterest(1, 100000, 1), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Home Loan at yearLoan = 30")
    public void testBoundaryYearLoanThirty() {
        assertEquals(5.0, calc.computeLoanInterest(1, 100000, 30), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Property Loan just below 100,000")
    public void testBoundaryPropertyLoanJustBelow100k() {
        assertEquals(8.5, calc.computeLoanInterest(2, 99999, 9), 0.001);
    }

    @Test
    @DisplayName("Boundary Test - Property Loan exactly 100,000")
    public void testBoundaryPropertyLoanExactly100k() {
        assertEquals(8.0, calc.computeLoanInterest(2, 100000, 6), 0.001);
    }

    // Equivalence Partitioning
    @Test
    @DisplayName("Equivalence Partitioning - Valid home loan")
    public void testEquivalenceValidHomeLoan() {
        assertEquals(8.0, calc.computeLoanInterest(1, 99999, 4), 0.001);
    }

    @Test
    @DisplayName("Equivalence Partitioning - Valid property loan")
    public void testEquivalenceValidPropertyLoan() {
        assertEquals(8.5, calc.computeLoanInterest(2, 99999, 9), 0.001);
    }

    @Test
    @DisplayName("Equivalence Partitioning - Invalid loan type")
    public void testEquivalenceInvalidLoanType() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(3, 200000, 5);
        });
    }

    @Test
    @DisplayName("Equivalence Partitioning - Home loan with invalid amount")
    public void testEquivalenceHomeLoanInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, -10000, 5);
        });
    }

    @Test
    @DisplayName("Equivalence Partitioning - Property loan with invalid amount")
    public void testEquivalencePropertyLoanInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(2, -10000, 5);
        });
    }

    @Test
    @DisplayName("Equivalence Partitioning - Year loan too low")
    public void testEquivalenceYearLoanTooLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, -1);
        });
    }

    @Test
    @DisplayName("Equivalence Partitioning - Year loan too high")
    public void testEquivalenceYearLoanTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, 31);
        });
    }

    @Test
    @DisplayName("Equivalence Partitioning - Valid loan amount with high yearLoan")
    public void testEquivalenceValidLoanHighYear() {
        assertEquals(5.0, calc.computeLoanInterest(1, 100000, 30), 0.001);
    }

    @Test
    @DisplayName("Equivalence Partitioning - Valid loan with average yearLoan")
    public void testEquivalenceValidLoanAverageYear() {
        assertEquals(6.5, calc.computeLoanInterest(1, 100000, 10), 0.001);
    }

    @Test
    @DisplayName("Equivalence Partitioning - Valid loan just above min yearLoan")
    public void testEquivalenceValidLoanJustAboveMinYear() {
        assertEquals(8.0, calc.computeLoanInterest(1, 100000, 1), 0.001);
    }

    // Extreme Values
    @Test
    @DisplayName("Extreme Value Test - Home Loan at maximum loan amount")
    public void testExtremeValueMaxLoanAmount() {
        assertEquals(5.0, calc.computeLoanInterest(1, Integer.MAX_VALUE, 30), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - Home Loan at minimum loan amount")
    public void testExtremeValueMinLoanAmount() {
        assertEquals(8.0, calc.computeLoanInterest(1, 0, 4), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - Very low loan amount")
    public void testExtremeValueVeryLowLoan() {
        assertEquals(8.0, calc.computeLoanInterest(1, 1, 4), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - Maximum years")
    public void testExtremeValueMaxYears() {
        assertEquals(5.0, calc.computeLoanInterest(1, 100000, 30), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - Zero years")
    public void testExtremeValueZeroYears() {
        assertEquals(0.0, calc.computeLoanInterest(1, 100000, 0), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - Negative years")
    public void testExtremeValueNegativeYears() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, -1);
        });
    }

    @Test
    @DisplayName("Extreme Value Test - High loan amount, low years")
    public void testExtremeValueHighLoanLowYears() {
        assertEquals(5.0, calc.computeLoanInterest(1, 1000000, 1), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - High loan amount, average years")
    public void testExtremeValueHighLoanAvgYears() {
        assertEquals(5.0, calc.computeLoanInterest(1, 1000000, 15), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - Low loan amount, high years")
    public void testExtremeValueLowLoanHighYears() {
        assertEquals(5.0, calc.computeLoanInterest(1, 1, 30), 0.001);
    }

    @Test
    @DisplayName("Extreme Value Test - Property Loan at high amount")
    public void testExtremeValuePropertyLoanHighAmount() {
        assertEquals(7.0, calc.computeLoanInterest(2, Integer.MAX_VALUE, 30), 0.001);
    }

    // Error Handling
    @Test
    @DisplayName("Error Handling Test - Negative loan amount")
    public void testErrorHandlingNegativeLoanAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, -100000, 5);
        });
    }

    @Test
    @DisplayName("Error Handling Test - Invalid loan type")
    public void testErrorHandlingInvalidLoanType() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(3, 100000, 5);
        });
    }

    @Test
    @DisplayName("Error Handling Test - Negative yearLoan")
    public void testErrorHandlingNegativeYearLoan() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, -5);
        });
    }

    @Test
    @DisplayName("Error Handling Test - Loan type out of range")
    public void testErrorHandlingLoanTypeOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(-1, 100000, 5);
        });
    }

    @Test
    @DisplayName("Error Handling Test - YearLoan out of range")
    public void testErrorHandlingYearLoanOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, 50);
        });
    }

    @Test
    @DisplayName("Error Handling Test - Loan amount = 0")
    public void testErrorHandlingLoanAmountZero() {
        assertEquals(0.0, calc.computeLoanInterest(1, 0, 5), 0.001);
    }

    @Test
    @DisplayName("Error Handling Test - YearLoan = 0")
    public void testErrorHandlingYearLoanZero() {
        assertEquals(0.0, calc.computeLoanInterest(1, 100000, 0), 0.001);
    }

    @Test
    @DisplayName("Error Handling Test - Property loan negative amount")
    public void testErrorHandlingPropertyLoanNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(2, -100000, 5);
        });
    }

    @Test
    @DisplayName("Error Handling Test - Property loan invalid type")
    public void testErrorHandlingPropertyLoanInvalidType() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(3, 100000, 5);
        });
    }

    @Test
    @DisplayName("Error Handling Test - YearLoan negative for property")
    public void testErrorHandlingPropertyYearLoanNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(2, 100000, -1);
        });
    }

    // Invalid Input Tests
    @Test
    @DisplayName("Invalid Input Test - Invalid loan type")
    public void testInvalidInputLoanType() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(-1, 100000, 5);
        });
    }

    @Test
    @DisplayName("Invalid Input Test - Negative loan amount")
    public void testInvalidInputNegativeLoanAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, -5000, 5);
        });
    }

    @Test
    @DisplayName("Invalid Input Test - Negative yearLoan")
    public void testInvalidInputNegativeYearLoan() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, -1);
        });
    }

    @Test
    @DisplayName("Invalid Input Test - String input instead of loan amount")
    public void testInvalidInputStringAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, Integer.parseInt("NotANumber"), 5);
        });
    }

    @Test
    @DisplayName("Invalid Input Test - String input instead of yearLoan")
    public void testInvalidInputStringYear() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, Integer.parseInt("NotANumber"));
        });
    }

    @Test
    @DisplayName("Invalid Input Test - Special characters in loan amount")
    public void testInvalidInputSpecialCharsLoanAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, Integer.parseInt("@#!$%"), 5);
        });
    }

    @Test
    @DisplayName("Invalid Input Test - Special characters in yearLoan")
    public void testInvalidInputSpecialCharsYear() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, Integer.parseInt("@#!$%"));
        });
    }

    @Test
    @DisplayName("Invalid Input Test - YearLoan too high")
    public void testInvalidInputYearLoanTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, 40);
        });
    }

    @Test
    @DisplayName("Invalid Input Test - YearLoan too low")
    public void testInvalidInputYearLoanTooLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.computeLoanInterest(1, 100000, -5);
        });
    }

    @Test
    @DisplayName("Invalid Input Test - Loan amount as null")
    public void testInvalidInputLoanAmountNull() {
        assertThrows(NullPointerException.class, () -> {
            calc.computeLoanInterest(1, (Double) null, 5);
        });
    }

    // Performance Testing
    @Test
    @DisplayName("Performance Test - Calculate interest for a large number of cases")
    public void testPerformanceLargeNumberOfCases() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            calc.computeLoanInterest(1, 100000, 5);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        assertTrue(duration < 1000, "Performance test exceeded 1000 ms");
    }

    // Null or Special Values
    @Test
    @DisplayName("Null Input Test - YearLoan as null")
    public void testNullInputsYearLoan() {
        assertThrows(NullPointerException.class, () -> {
            calc.computeLoanInterest(1, 100000, (Integer) null);
        });
    }

    @Test
    @DisplayName("Null Input Test - LoanAmount as null")
    public void testNullInputsLoanAmount() {
        assertThrows(NullPointerException.class, () -> {
            calc.computeLoanInterest(1, (Double) null, 5);
        });
    }

    @Test
    @DisplayName("Null Input Test - Invalid loan type null")
    public void testNullInputsInvalidLoanType() {
        assertThrows(NullPointerException.class, () -> {
            calc.computeLoanInterest((Integer) null, 100000, 5);
        });
    }

    // Dummy scenarios to demonstrate usage of additional assertions
    @Test
    @DisplayName("Assert Array Equality (dummy scenario)")
    public void testAssertArrayEquals() {
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Home Loan iterable list (dummy scenario)")
    public void testAssertIterableEquals() {
        Iterable<Double> expected = Arrays.asList(8.0, 6.5, 5.5);
        Iterable<Double> actual = Arrays.asList(calc.computeLoanInterest(1, 90000, 4),
                calc.computeLoanInterest(1, 90000, 7),
                calc.computeLoanInterest(1, 90000, 12));
        assertIterableEquals(expected, actual);
    }
}









































/*import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CalcInterestTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private CalcInterest calc = new CalcInterest();

    @org.junit.Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // Test the main method
    @Test
    public void testMain() {
        CalcInterest.main(null);

        // Verify the output
        String expectedOutput = "Test Case 1 (Expected 8%): 8.0%\n" +
                                "Test Case 2 (Expected 6.5%): 6.5%\n" +
                                "Test Case 3 (Expected 8.5%): 8.5%\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    // Existing Test Cases
    @Test
    public void testHomeLoanCase1() {
        assertEquals(8.0, calc.computeLoanInterest(1, 99999, 4), 0.001);
    }
   @Test
    public void testHomeLoanCase2() {
        assertEquals(6.5, calc.computeLoanInterest(1, 100000, 5), 0.001);
    }

    @Test
    public void testPropertyLoanCase3() {
        assertEquals(8.5, calc.computeLoanInterest(2, 99999, 9), 0.001);
    }

    // New Test Cases for Comprehensive Coverage

    @Test
    public void testHomeLoanBoundaryCase_LoanAmount500001_YearLoan11() {
        assertEquals(5.5, calc.computeLoanInterest(1, 500001, 11), 0.001);
    }

    @Test
    public void testPropertyLoanBoundaryCase_LoanAmount500001_YearLoan11() {
        assertEquals(7.0, calc.computeLoanInterest(2, 500001, 11), 0.001);
    }

    @Test
    public void testInvalidLoanType() {
        assertEquals(-1, calc.computeLoanInterest(3, 200000, 5), 0.001);
    }

    @Test
    public void testHomeLoan_LoanAmount400000_YearLoan8() {
        assertEquals(6.5, calc.computeLoanInterest(1, 400000, 8), 0.001);
    }

    @Test
    public void testPropertyLoan_LoanAmount150000_YearLoan6() {
        assertEquals(8.5, calc.computeLoanInterest(2, 150000, 6), 0.001);
    }

    // Additional Tests to cover remaining branches

    @Test
    public void testHomeLoanYearLoanUnder5() {
        assertEquals(8.0, calc.computeLoanInterest(1, 90000, 4), 0.001);
    }

    @Test
    public void testHomeLoanYearLoanBetween5And10() {
        assertEquals(6.5, calc.computeLoanInterest(1, 90000, 7), 0.001);
    }

    @Test
    public void testHomeLoanYearLoanAbove11() {
        assertEquals(5.5, calc.computeLoanInterest(1, 90000, 12), 0.001);
    }

    @Test
    public void testPropertyLoanYearLoanUnder5() {
        assertEquals(12.0, calc.computeLoanInterest(2, 90000, 4), 0.001);
    }

    @Test
    public void testPropertyLoanYearLoanBetween5And10() {
        assertEquals(8.5, calc.computeLoanInterest(2, 90000, 7), 0.001);
    }

    @Test
    public void testPropertyLoanYearLoanAbove11() {
        assertEquals(7.0, calc.computeLoanInterest(2, 90000, 12), 0.001);
    }
}

*/
