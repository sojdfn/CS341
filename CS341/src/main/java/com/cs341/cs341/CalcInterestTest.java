import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalcInterestTest {

    // Create an instance of CalcInterest to use in tests
    CalcInterest calc = new CalcInterest();

    // 10 tests expected to pass
    @Test
    public void testHomeLoanCase1() {
        assertEquals(8.0, calc.computeLoanInterest(1, 99999, 4), 0.001);
    }

    @Test
    public void testHomeLoanCase2() {
        assertEquals(6.5, calc.computeLoanInterest(1, 100000, 5), 0.001);
    }

    @Test
    public void testHomeLoanCase3() {
        assertEquals(5.5, calc.computeLoanInterest(1, 500001, 11), 0.001);
    }

    @Test
    public void testPropertyLoanCase1() {
        assertEquals(8.5, calc.computeLoanInterest(2, 99999, 9), 0.001);
    }

    @Test
    public void testPropertyLoanCase2() {
        assertEquals(8.5, calc.computeLoanInterest(2, 100000, 10), 0.001);
    }

    @Test
    public void testPropertyLoanCase3() {
        assertEquals(7.0, calc.computeLoanInterest(2, 500001, 11), 0.001);
    }

    @Test
    public void testHomeLoanCase4() {
        assertEquals(6.5, calc.computeLoanInterest(1, 300000, 8), 0.001);
    }

    @Test
    public void testPropertyLoanCase4() {
        assertEquals(8.5, calc.computeLoanInterest(2, 200000, 7), 0.001);
    }

    @Test
    public void testHomeLoanCase5() {
        assertEquals(5.5, calc.computeLoanInterest(1, 400000, 11), 0.001);
    }

    @Test
    public void testPropertyLoanCase5() {
        assertEquals(8.5, calc.computeLoanInterest(2, 150000, 6), 0.001);
    }

    // 11 tests expected to fail (incorrect expectations)
    @Test
    public void testHomeLoanFailCase1() {
        assertEquals(9.0, calc.computeLoanInterest(1, 99999, 4), 0.001); // Should return 8.0
    }

    @Test
    public void testHomeLoanFailCase2() {
        assertEquals(7.0, calc.computeLoanInterest(1, 100000, 5), 0.001); // Should return 6.5
    }

    @Test
    public void testHomeLoanFailCase3() {
        assertEquals(6.0, calc.computeLoanInterest(1, 500001, 11), 0.001); // Should return 5.5
    }

    @Test
    public void testPropertyLoanFailCase1() {
        assertEquals(10.0, calc.computeLoanInterest(2, 99999, 9), 0.001); // Should return 8.5
    }

    @Test
    public void testPropertyLoanFailCase2() {
        assertEquals(9.5, calc.computeLoanInterest(2, 100000, 10), 0.001); // Should return 8.5
    }

    @Test
    public void testPropertyLoanFailCase3() {
        assertEquals(8.0, calc.computeLoanInterest(2, 500001, 11), 0.001); // Should return 7.0
    }

    @Test
    public void testHomeLoanFailCase4() {
        assertEquals(6.0, calc.computeLoanInterest(1, 300000, 8), 0.001); // Should return 6.5
    }

    @Test
    public void testPropertyLoanFailCase4() {
        assertEquals(9.0, calc.computeLoanInterest(2, 200000, 7), 0.001); // Should return 8.5
    }

    @Test
    public void testHomeLoanFailCase5() {
        assertEquals(6.0, calc.computeLoanInterest(1, 400000, 11), 0.001); // Should return 5.5
    }

    @Test
    public void testPropertyLoanFailCase5() {
        assertEquals(7.5, calc.computeLoanInterest(2, 150000, 6), 0.001); // Should return 8.5
    }

    @Test
    public void testInvalidLoanType() {
        assertEquals(-1, calc.computeLoanInterest(3, 200000, 5), 0.001); // Invalid loan type
    }
}
