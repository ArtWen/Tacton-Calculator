package tacton.calculator;

import java.util.Stack;

public class StringCalculator {
	
	/*
	 * Calculates value of string expression using Shunting Yard Algorithm
	 * 
	 * @param	expression	space separated string constructed using integers and basic operators ("+", "-", "*", "/") 
	 * @return				result of given math expression with regards of order of operations
	 */
	public static Double calculate(String expression) {
		if(expression == null) return null;
		Stack<Double> numbers = new Stack<Double>();
		Stack<Operator> operatorsStack = new Stack<Operator>();
		
		for (String el: expression.split(" ")) {
			if(!Operator.isOperator(el)) {
				numbers.add(Double.parseDouble(el));
			}
			else {
				Operator currentOperator = Operator.getByString(el);
				while(!operatorsStack.empty() && currentOperator.weight <= operatorsStack.peek().weight) {
					Double right = numbers.pop();
					Double left = numbers.pop();
					numbers.add(operatorsStack.pop().applyAsDouble(left, right));
				}
				operatorsStack.add(currentOperator);
			}
			
		}
		
		while(!operatorsStack.empty()) {
			Double right = numbers.pop();
			Double left = numbers.pop();
			numbers.add(operatorsStack.pop().applyAsDouble(left, right));
		}
		return numbers.pop();
	}
}
