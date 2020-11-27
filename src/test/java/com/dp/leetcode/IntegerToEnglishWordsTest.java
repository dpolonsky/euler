package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToEnglishWordsTest {

	@Test
	void numberToWords() {
		IntegerToEnglishWords en = new IntegerToEnglishWords();
		String res = en.numberToWords(123);
		Assert.check("One Hundred Twenty Three".equals(res));
	}
}