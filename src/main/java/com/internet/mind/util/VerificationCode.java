package com.internet.mind.util;


import java.util.Random;

public class VerificationCode {

    public String getCode() {
        char[] codes = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
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
}
