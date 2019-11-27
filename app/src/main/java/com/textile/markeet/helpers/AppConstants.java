package com.textile.markeet.helpers;

import android.content.Context;

import java.util.regex.Pattern;

public class AppConstants {

    public static final String BASE_URL = "https://www.textilemarkeet.com/";
    public static Context mContext;

    public static final Pattern PASSWORD
            = Pattern.compile("^" +
            "(?=.*[0-9])" +
            "(?=.*[a-zA-Z])" +
            "(?=\\S+$)" +
            ".{6,}" +
            "$");

}


