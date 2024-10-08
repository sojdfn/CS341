import static org.junit.Assert.assertEquals;
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
