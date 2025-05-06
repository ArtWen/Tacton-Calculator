package tacton.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OperatorTest {
	
	@Test
	public void testAddOperator() {
		assertTrue(Operator.isOperator("+"));
		
		Operator actual = Operator.getByString("+");
		Operator expected = Operator.ADD;
		
		assertEquals(expected, actual);
		assertEquals(2+3, actual.applyAsDouble(2, 3));
	}
	
	@Test
	public void testSubtractOperator() {
		assertTrue(Operator.isOperator("-"));
		
		Operator actual = Operator.getByString("-");
		Operator expected = Operator.SUBTRACT;
		
		assertEquals(expected, actual);
		assertEquals(2-3, actual.applyAsDouble(2, 3));
	}
	@Test
	public void testMultiplyOperator() {
		assertTrue(Operator.isOperator("*"));
		
		Operator actual = Operator.getByString("*");
		Operator expected = Operator.MULTIPLY;
		
		assertEquals(expected, actual);
		assertEquals(2*3, actual.applyAsDouble(2, 3));
	}
	@Test
	public void testDivideOperator() {
		assertTrue(Operator.isOperator("/"));
		
		Operator actual = Operator.getByString("/");
		Operator expected = Operator.DIVIDE;
		
		assertEquals(expected, actual);
		assertEquals(2d/3d, actual.applyAsDouble(2, 3));
	}
	
	@Test
	public void testNotOperator() {
		assertFalse(Operator.isOperator("10"));
		assertFalse(Operator.isOperator("-1"));
	}
}
