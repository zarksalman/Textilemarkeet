package com.textile.markeet.views.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.textile.markeet.R
import com.textile.markeet.helpers.AppConstants
import com.textile.markeet.viewmodels.SignInUpViewModel
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.m_tool_bar.view.*

class SigninActivity : BaseActivity() {

    private val TAG = "SigninActivity"
    var userName: String = ""
    var userPass: String = ""
    lateinit var signInUpViewModel: SignInUpViewModel
    var parameters = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signInUpViewModel = ViewModelProviders.of(this).get(SignInUpViewModel::class.java)

        initBasicUi()
        initClickListeners()

    }

    private fun initBasicUi() {
        signin_tool_bar.tv_screen_title.text = resources.getString(R.string.sign_in)
    }

    private fun initClickListeners() {

        signin_tool_bar.btn_back.setOnClickListener { onBackPressed() }
        btn_sign_in.setOnClickListener {
            if (validate()) {
                signinForm()
            }
        }
        btn_fb_sign_in.setOnClickListener { }
        btn_google_sign_in.setOnClickListener { }
    }

    private fun validate(): Boolean {

        userName = et_email_signin.text.toString()
        userPass = et_password_signin.text.toString()

        return when {
            userName.isEmpty() -> {
                Toast.makeText(this, "Name / Email could not be empty", Toast.LENGTH_LONG).show()
                false
            }
            userPass.isEmpty() -> {
                Toast.makeText(this, "Password could not be empty", Toast.LENGTH_LONG).show()
                false
            }
            else -> true
        }
    }

    private fun signinForm() {

        parameters.clear()
        parameters["username"] = userName
        parameters["password"] = userPass
        parameters["social_media_login"] = "false"

        signInUpViewModel.signinForm(parameters).observe(this, Observer { signinDataContainer ->

            signinDataContainer?.let {
                saveString(AppConstants.TOKEN, it.getSessionToken().toString())
                Toast.makeText(this@SigninActivity, it.getMessage(), Toast.LENGTH_SHORT).show()
                Log.d(TAG, it.getMessage())
            }
        })
    }
}
