package com.dp.leetcode;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionAddOperandsTest {

	@Test
	void addOperators() {
		ExpressionAddOperands operands = new ExpressionAddOperands();
		List<String> strings = operands.addOperators("126", 6);
		strings.size();
//		Assert.check(strings.size() == 1);
	}
}