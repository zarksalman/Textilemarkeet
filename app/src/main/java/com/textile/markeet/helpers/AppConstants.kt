package com.textile.markeet.helpers

import android.content.Context
import java.util.regex.Pattern

class AppConstants {


    companion object {

        const val BASE_URL = "http://textilemarkeet.com/wp-json/textilemarkeet/v1/"
        var mContext: Context? = null
        const val TOKEN = "session_token"
        const val BEARER = "Bearer "

        val PASSWORD = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-zA-Z])" +
                    "(?=\\S+$)" +
                    ".{6,}" +
                    "$"
        )
    }
}