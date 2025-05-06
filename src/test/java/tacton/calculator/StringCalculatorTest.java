package tacton.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest
{

	@Test
    public void testCalculate_SimpleAddition()
    {
		String testedExpression = "2 + 3";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 5d;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_SimpleSubtraction()
    {
		String testedExpression = "4 - 1";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 3d;
        assertEquals(expected, actual);
    }
	
	
	@Test
    public void testCalculate_SimpleMultiplication()
    {
		String testedExpression = "4 * 2";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 8d;
        assertEquals(expected, actual);
    }
	
	
	@Test
    public void testCalculate_SimpleDivision()
    {
		String testedExpression = "8 / 2";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 4d;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_AllOperators()
    {
		String testedExpression = "1 + 2 - 3 * 4 / 2";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = -3d;
        assertEquals(expected, actual);
    }
	

	@Test
    public void testCalculate_Example2FromTaskSheet()
    {
		String testedExpression = "3 * 2 + 1";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 7d;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_Example3FromTaskSheet()
    {
		String testedExpression = "3 * -2 + 6";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 0d;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_DoubleDigits()
    {
		String testedExpression = "33 * 2 - 32 / 2";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 50d;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_Null()
    {
		String testedExpression = null;
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = null;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_SingleNumber()
    {
		String testedExpression = "5";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 5d;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_DivisionByZero_PositiveINF()
    {
		String testedExpression = "1 / 0";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_DivisionByZero_NegativeINF()
    {
		String testedExpression = "-1 / 0";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_Division_Fractions()
    {
		String testedExpression = "7 / 2";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 3.5;
        assertEquals(expected, actual);
    }
	
	@Test
    public void testCalculate_LongExpression()
    {
		String testedExpression = "2 - 4 * 7 + 12 + 23 + 3 - 8 / 2 * 12 - 3 + -5 - -8 * -5";
		Double actual = StringCalculator.calculate(testedExpression);
		Double expected = 2d - 4d * 7d + 12d + 23d + 3d - 8d / 2d * 12d - 3d + -5d - -8d * -5d;
        assertEquals(expected, actual);
    }
}
