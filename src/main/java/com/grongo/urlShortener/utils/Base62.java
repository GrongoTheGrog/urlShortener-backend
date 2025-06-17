package com.grongo.urlShortener.utils;

import java.util.ArrayList;
import java.util.List;

public class Base62{

    private static String base62encodingChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long number){
        if (number == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();

        while(number > 0){
            int remainder = (int) number % 62;
            stringBuilder.append(base62encodingChars.charAt(remainder));
            number /= 62;
        }

        return stringBuilder.reverse().toString();
    }

    public static long decode(String string){
        long sum = 0;
        int stringLength = string.length();

        for (int i = stringLength - 1; i >= 0; i--){
            int index = base62encodingChars.indexOf(string.charAt(stringLength - (i + 1)));
            sum = (long) (sum + Math.pow(62, i) * index);
        }

        return sum;
    }
}
