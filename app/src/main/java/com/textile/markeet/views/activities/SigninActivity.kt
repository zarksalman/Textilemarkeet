package com.textile.markeet.views.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.textile.markeet.R
import com.textile.markeet.viewmodels.SigninViewModel
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.m_tool_bar.view.*

class SigninActivity : AppCompatActivity() {

    private val TAG = "SininActivity"
    lateinit var signinViewModel: SigninViewModel
    var parameters = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signinViewModel = ViewModelProviders.of(this).get(SigninViewModel::class.java)

        initBasicUi()
        initClickListeners()

    }

    private fun initBasicUi() {
        signin_tool_bar.tv_screen_title.text = resources.getString(R.string.sign_in)
    }

    private fun initClickListeners() {

        signin_tool_bar.btn_back.setOnClickListener { onBackPressed() }
        btn_sign_in.setOnClickListener { setParameters() }
        btn_fb_sign_in.setOnClickListener { }
        btn_google_sign_in.setOnClickListener { }
    }

    private fun setParameters() {

        parameters.clear()
        val userName = et_email_signin.text.toString()
        val userPass = et_password_signin.text.toString()

        if (userName.isNullOrEmpty()) {
            Toast.makeText(this, "Name / Email could not be empty", Toast.LENGTH_LONG).show()
            return
        }

        if (userPass.isNullOrEmpty()) {
            Toast.makeText(this, "Password could not be empty", Toast.LENGTH_LONG).show()
            return
        }

        parameters["user_name"] = userName
        parameters["user_password"] = userPass

        signin()
    }

    private fun signin() {

        signinViewModel.signinForm(parameters).observe(this, Observer { signinDataContainer ->
            run {
                if (signinDataContainer != null) {
                    Log.d(TAG, signinDataContainer.message)
                }
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
