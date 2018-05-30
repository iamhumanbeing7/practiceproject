package com.test;

import java.math.BigInteger;

public class testmain {
    public static void main(String[] argv) throws Exception {
        BigInteger bi1 = new BigInteger("1234567890123456890");
        int exponent = 2;

        BigInteger b2 = bi1.pow(exponent);
        System.out.println(b2);
        System.out.println(bi1.multiply(bi1));
    }
}
