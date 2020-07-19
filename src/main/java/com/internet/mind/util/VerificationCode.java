package com.internet.mind.util;


import org.junit.Test;

import java.util.Random;

public class VerificationCode {

    public String getCode() {
        char[] codes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String resCode = "";
        Random random = new Random();
        while (true) {
            if (resCode.length() == 6) {
                break;
            }
            int i = random.nextInt(codes.length);
            resCode += codes[i];
        }
        return resCode;
    }

    @Test
    public void testCode() {
        System.out.println(this.getCode());
    }
}
