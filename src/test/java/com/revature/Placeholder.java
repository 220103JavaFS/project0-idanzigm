package com.revature;

import java.util.Base64;
import java.util.Base64.Encoder;

public class Placeholder {
    public static void main(String[] args) {
        String originalString = "first";
        Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(originalString.getBytes());

        System.out.println(encodedString);
    }
}
