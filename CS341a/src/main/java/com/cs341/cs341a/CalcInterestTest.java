import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalcInterestTest {

    @Test
    public void testHomeLoanBelow100kLessThan5Years() {
        // Home loan, amount < 100,000, year < 5
        assertEquals(8.0, CalcInterest.computeLoanInterest(99999, 4, 1), 0.001, "Home loan, < 100k, < 5 years should be 8%");
    }

    @Test
    public void testHomeLoanEqual100k5Years() {
        // Home loan, amount = 100,000, year = 5
        assertEquals(6.5, CalcInterest.computeLoanInterest(100000, 5, 1), 0.001, "Home loan, 100k, 5 years should be 6.5%");
    }

    @Test
    public void testHomeLoanAbove500kMoreThan11Years() {
        // Home loan, amount > 500,000, year >= 11
        assertEquals(5.5, CalcInterest.computeLoanInterest(500001, 11, 1), 0.001, "Home loan, > 500k, >= 11 years should be 5.5%");
    }

    @Test
    public void testInvalidHomeLoanNegativeAmount() {
        // Invalid loan amount (negative)
        assertEquals(-1, CalcInterest.computeLoanInterest(-10000, 5, 1), "Invalid loan amount should return -1");
    }

    @Test
    public void testPropertyLoanBelow100kBetween5And10Years() {
        // Property loan, amount < 100,000, year between 5 and 10
        assertEquals(8.5, CalcInterest.computeLoanInterest(99999, 9, 2), 0.001, "Property loan, < 100k, 5-10 years should be 8.5%");
    }

    @Test
    public void testPropertyLoanEqual500kExactly10Years() {
        // Property loan, amount = 500,000, year = 10
        assertEquals(8.5, CalcInterest.computeLoanInterest(500000, 10, 2), 0.001, "Property loan, 100k-500k, 5-10 years should be 8.5%");
    }

    @Test
    public void testPropertyLoanAbove500kMoreThan11Years() {
        // Property loan, amount > 500,000, year >= 11
        assertEquals(7.0, CalcInterest.computeLoanInterest(500001, 11, 2), 0.001, "Property loan, > 500k, >= 11 years should be 7%");
    }

    @Test
    public void testInvalidLoanType() {
        // Invalid loan type
        assertEquals(-1, CalcInterest.computeLoanInterest(100000, 5, 3), "Invalid loan type should return -1");
    }

    @Test
    public void testInvalidYearLoanZero() {
        // Invalid year (zero)
        assertEquals(-1, CalcInterest.computeLoanInterest(100000, 0, 2), "Invalid year should return -1");
    }

    @Test
    public void testInvalidLoanAmountZero() {
        // Invalid loan amount (zero)
        assertEquals(-1, CalcInterest.computeLoanInterest(0, 5, 1), "Invalid loan amount should return -1");
    }
}
