package tacton.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public enum Operator implements DoubleBinaryOperator {
	ADD("+", 1, (left, right) -> {return left + right;}),
	SUBTRACT("-", 1, (left, right) -> {return left - right;}),
	MULTIPLY("*", 2, (left, right) -> {return left * right;}),
	DIVIDE("/", 2, (left, right) -> {return left / right;});
	
	public final String sign;
	public final Integer weight;
	private final DoubleBinaryOperator doubleBinaryOperator;
	
	private Operator(String sign, Integer weight, DoubleBinaryOperator doubleBinaryOperator) {
		this.sign = sign;
		this.weight = weight;
		this.doubleBinaryOperator = doubleBinaryOperator;
	}
	
    private static final Map<String, Operator> OPERATORS_MAP = new HashMap<>();
    
    static {
        for (Operator op: values()) OPERATORS_MAP.put(op.sign, op);
    }

    public static Operator getByString(String sign) {
        return OPERATORS_MAP.get(sign);
    }
    
	public static boolean isOperator(String sign) {
		return OPERATORS_MAP.containsKey(sign);
	}

	@Override
	public double applyAsDouble(double left, double right) {
		return doubleBinaryOperator.applyAsDouble(left, right);
	}

}
