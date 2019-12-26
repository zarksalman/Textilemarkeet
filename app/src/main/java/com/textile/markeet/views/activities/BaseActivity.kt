package com.textile.markeet.views.activities

import android.app.ProgressDialog
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.textile.markeet.helpers.AppPreference
import com.textile.markeet.helpers.AppUtils


open class BaseActivity : AppCompatActivity() {

    var appPreference: AppPreference? = null
    var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appPreference = AppPreference.getInstance(this)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog?.setMessage("Loading")
        mProgressDialog?.setCancelable(false)
    }

    fun setLayout(layout: Int) {
        setContentView(layout)

    }

    fun saveString(key: String, value: String) {
        appPreference?.setString(key, value)
    }

    fun getString(key: String): String? {
        return appPreference?.getString(key)
    }

    fun showProgressBar() {
        mProgressDialog?.show()
    }

    fun hideProgressBar() {
        mProgressDialog?.hide()
    }

}