package com.dp.math;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomBigIntegerTest
{

    @Test
    void addDifferentLengths()
    {
        CustomBigInteger num1 = new CustomBigInteger("10010");
        CustomBigInteger res = num1.add(new CustomBigInteger("20"));
        assertEquals("10030", res.toString());
    }

    @Test
    void addWithCarry()
    {
        CustomBigInteger num1 = new CustomBigInteger("10999");
        CustomBigInteger res = num1.add(new CustomBigInteger("111"));
        assertEquals("11110", res.toString());
    }

    @Test
    void addWithCarry2()
    {
        CustomBigInteger num1 = new CustomBigInteger("9999");
        CustomBigInteger res = num1.add(new CustomBigInteger("9999"));
        assertEquals("19998", res.toString());
    }

    @Test
    void addVeryLong()
    {
        CustomBigInteger num1 = new CustomBigInteger("10088888888888888888888888888888888888888888888888888888888888888");
        CustomBigInteger res = num1.add(new CustomBigInteger("1112"));
        assertEquals("10088888888888888888888888888888888888888888888888888888888890000", res.toString());
    }

    @Test
    void multiply()
    {
        CustomBigInteger num1 = new CustomBigInteger("356");
        CustomBigInteger res = num1.multiply(new CustomBigInteger("23"));
        assertEquals("8188", res.toString());

        num1 = new CustomBigInteger("23");
        res = num1.multiply(new CustomBigInteger("356"));
        assertEquals("8188", res.toString());
    }

    @Test
    void pow()
    {
        double expected = Math.pow(2, 10);
        CustomBigInteger num = new CustomBigInteger("2").pow(10);
        assertEquals(String.format("%.0f", expected), num.toString());
    }

    @Test
    void powBigInt()
    {
        long start = System.currentTimeMillis();
        String expected = new BigInteger("2", 10).pow(100000).toString();
        System.out.printf("Executed biginteregr pow %s,\ntook:%d\n", expected, System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        String actual = new CustomBigInteger("2").pow(100000).toString();
        System.out.printf("Executed custominteregr pow %s,\ntook:%d\n", actual, System.currentTimeMillis() - start);
        assertEquals(expected, actual);
    }
}