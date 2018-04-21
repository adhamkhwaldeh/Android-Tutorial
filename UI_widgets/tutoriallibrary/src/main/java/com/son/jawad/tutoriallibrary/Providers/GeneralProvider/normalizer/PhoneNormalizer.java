package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.normalizer;

import java.util.regex.Pattern;

public class PhoneNormalizer {

    private static Pattern ignorePattern = Pattern.compile("[-.():/ ]");

    public static String simplifyPhoneNumber(String phoneNumber) {
        return ignorePattern.matcher(phoneNumber).replaceAll("");
    }
}
