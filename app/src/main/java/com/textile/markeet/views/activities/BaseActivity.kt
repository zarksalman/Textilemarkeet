package com.textile.markeet.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.textile.markeet.helpers.AppPreference

open class BaseActivity : AppCompatActivity() {

    lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appPreference = AppPreference.getInstance(this)
    }

    fun saveString(key: String, value: String) {
        appPreference.setString(key, value)
    }

    fun getString(key: String): String? {
        return appPreference.getString(key)
    }
}