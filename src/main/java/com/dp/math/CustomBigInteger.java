package com.dp.math;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class CustomBigInteger
{
    private int[] value;
    int radix = 10;

    public CustomBigInteger(String number)
    {
        if (number == null || number.length() == 0) {
            throw new NumberFormatException("Empty or null value");
        }

        value = new int[number.length()];
        char[] charArray = number.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isDigit(charArray[i])) {
                throw new NumberFormatException("Invalid character in number string");
            }
            value[i] = Character.digit(charArray[i], radix);
        }
    }

    public CustomBigInteger(int[] value)
    {
        this.value = value;
    }

    public CustomBigInteger add(CustomBigInteger otherNumber)
    {
        int[] src, dst;
        int alignedSize = Math.max(size(), otherNumber.size());
        if (size() < otherNumber.size()) {
            src = fillHeadWithDigits(this, alignedSize, 0);
            dst = otherNumber.value;
        }
        else if (size() > otherNumber.size()) {
            src = value;
            dst = fillHeadWithDigits(otherNumber, alignedSize, 0);
        }
        else {
            src = value;
            dst = otherNumber.value;
        }

        int newSize = alignedSize + 1;
        int[] result = new int[newSize];
        int carry = 0;
        for (int i = alignedSize - 1; i >= 0 || carry > 0; i--) {
            int currentNumber = (i >= 0 && i < alignedSize) ? src[i] + dst[i] + carry : carry;
            result[newSize - (alignedSize - i - 1) - 1] = currentNumber % radix;
            carry = currentNumber / radix;
        }
        result = removeFillDigits(result, 0);
        return new CustomBigInteger(result);
    }

    public CustomBigInteger multiply(CustomBigInteger otherNumber)
    {
        int carry = 0;
        int newSize = size() + otherNumber.size();
        int[] result = new int[newSize];
        Arrays.fill(result, 0);
        CustomBigInteger resultInteger = new CustomBigInteger(result);
        int padding = 0;
        for (int i = otherNumber.size() - 1; i >= 0; i--, padding++) {
            int[] stepResult = new int[newSize];
            Arrays.fill(stepResult, 0);

            for (int j = size() - 1; j >= 0; j--) {
                int currentNumber = otherNumber.getInt(i) * value[j] + carry;
                stepResult[newSize - (size() - j - 1) - 1 - padding] = currentNumber % radix;
                carry = currentNumber / radix;
            }
            if (carry > 0) { stepResult[newSize - (size() + 1) - padding] = carry % radix; }

            resultInteger = resultInteger.add(new CustomBigInteger(stepResult));
            carry = 0;
        }
        return new CustomBigInteger(removeFillDigits(resultInteger.value, 0));
    }

    public CustomBigInteger pow(int exponent)
    {
        CustomBigInteger result = new CustomBigInteger(value);
        for (int i = 1; i < exponent; i++, result = result.multiply(this)) { ; }
        return result;
    }

    CustomBigInteger power(CustomBigInteger x, int y)
    {
        CustomBigInteger temp;
        if (y == 0) { return new CustomBigInteger("1"); }
        temp = power(x, y / 2);

        if (y % 2 == 0) { return temp.multiply(temp); }
        else {
            if (y > 0) { return x.multiply(temp).multiply(temp); }
            else { return temp.multiply(temp).divide(x); }
        }
    }

    private CustomBigInteger divide(CustomBigInteger x)
    {
        throw new NotImplementedException();
    }

    private int[] fillHeadWithDigits(CustomBigInteger otherNumber, int size, int fillDigit)
    {
        if (otherNumber.size() == size) { return otherNumber.value; }

        int[] value = new int[size];
        Arrays.fill(value, fillDigit);
        System.arraycopy(otherNumber.value, 0, value, size - otherNumber.value.length, otherNumber.value.length);
        return value;
    }

    private int[] removeFillDigits(int[] array, int digit)
    {
        int i = 0;
        for (; array[i] == digit && i < array.length - 1; i++) { ; }

        if (i == 0) { return array; }

        int newSize = array.length - i;
        int[] result = new int[newSize];
        System.arraycopy(array, i, result, 0, newSize);
        return result;
    }

//    CustomBigInteger multiply(CustomBigInteger otherNumber)
//    {
//
//    }

    int getInt(int n)
    {
        if (n < 0) { return 0; }
        if (n >= value.length) { return -1; }

        return value[n];
    }

    public int size()
    {
        return value.length;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for (int digit : value) {
            result.append(digit);
        }
        return result.toString();
    }
}
