package com.dp.leetcode;

import java.util.LinkedList;

// "3+2*2"
public class BasicCalculatorII {
	public int calculate(String s) {
		int md=-1; // 0 is m, 1 is d
		int sign=1; // 1 is +, -1 is -
		int prev=0;
		int result=0;

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				int num = c-'0';
				while(++i<s.length() && Character.isDigit(s.charAt(i))){
					num = num*10+s.charAt(i)-'0';
				}
				i--; // back to last digit of number

				if(md==0){
					prev = prev * num;
					md=-1;
				}else if(md==1){
					prev = prev / num;
					md=-1;
				}else{
					prev = num;
				}
			}else if(c=='/'){
				md=1;
			}else if(c=='*'){
				md=0;
			}else if(c=='+'){
				result = result + sign*prev;
				sign=1;
			}else if(c=='-'){
				result = result + sign*prev;
				sign=-1;
			}
		}

		result = result + sign*prev;
		return result;
	}

	public int calculateExpensive(String s) {
		LinkedList<String> list = parseToStack(s);

		LinkedList<String> stack = processMultiplyDevision(list);

		return processPlusMinus(stack);
	}

	private LinkedList<String> processMultiplyDevision(LinkedList<String> list) {
		String lastExpr = "";
		LinkedList<String> stack  = new LinkedList<>();
		for (String item : list){
			if ( isNumber(item)){
				if ( stack.isEmpty()){
					stack.addLast(item);
				}else{
					if ( lastExpr.equals("+") || lastExpr.equals("-")){
						stack.addLast(item);
					}else{
						String exp = stack.pollLast();
						Integer operand = Integer.valueOf(stack.pollLast());
						if ( exp.equals("*")){
							stack.add(operand * Integer.valueOf(item)+ "");
						}else if ( exp.equals("/")){
							stack.add(operand / Integer.valueOf(item)+ "");
						}
					}
				}
			}else{
				lastExpr = item;
				stack.addLast(item);
			}
		}
		return stack;
	}

	private Integer processPlusMinus(LinkedList<String> stack) {
		Integer result = null;
		String expr = "";
		while (!stack.isEmpty()) {
			String value = stack.pollFirst();
			if (isNumber(value)) {
				if (result == null) {
					result = Integer.valueOf(value);
				} else if (!isEmpty(expr)) {
					int b = Integer.valueOf(value);
					if (expr.equals("+")) {
						result += b;
					} else if (expr.equals("-")) {
						result -= b;
					}
					expr = null;
				}
			} else if (isExpression(value)) {
				expr = value;
			}
		}
		return result;
	}

	private LinkedList<String> parseToStack(String s) {
		LinkedList<String> stack  = new LinkedList<>();
		String num = "";
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				num += c;
			} else if (isOperation(c)) {
				if (!isEmpty(num)) {
					stack.addLast(num);
				}
				stack.addLast(String.valueOf(c));
				num = "";
			}
		}
		if (!isEmpty(num)) {
			stack.addLast(num);
		}
		return stack;
	}

	private boolean isOperation(char c) {
		return '+' == c || '-' == c || '*' == c || '/' == c;
	}

	boolean isExpression(String value) {
		return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
		
	}

	public boolean isEmpty(String s)
	{
		return null == s || "".equals(s);
	}

	public boolean isNumber(String input)
	{
		for (char c : input.toCharArray()) {
			if (c - '0' < 0 || c - '0' > 9) {
				return false;
			}
		}
		return true;
	}

}
