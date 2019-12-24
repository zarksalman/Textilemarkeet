package com.textile.markeet.views.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.textile.markeet.R
import com.textile.markeet.helpers.AppConstants
import com.textile.markeet.viewmodels.SignInUpViewModel
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.m_tool_bar.view.*

class SignupActivity : BaseActivity() {

    private val TAG = "SignupActivity"
    lateinit var signInUpViewModel: SignInUpViewModel
    var userName: String = ""
    var phone: String = ""
    var email: String = ""
    var password: String = ""
    var confirmPassword: String = ""

    var parameters = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signInUpViewModel = ViewModelProviders.of(this).get(SignInUpViewModel::class.java)

        setBasicUi()
        setClickListeners()
    }

    private fun setBasicUi() {
        signup_tool_bar.tv_screen_title.text = resources.getString(R.string.sign_up)
    }

    private fun setClickListeners() {

        signup_tool_bar.btn_back.setOnClickListener { onBackPressed() }
        btn_sign_up.setOnClickListener {

            if (validate()) {
                signupForm()
            }
        }
        btn_fb_sign_up.setOnClickListener { }
        btn_google_sign_up.setOnClickListener { }
    }

    private fun validate(): Boolean {

        userName = et_first_name.text.toString()
        phone = et_contact_number.text.toString()
        email = et_email.text.toString()
        password = et_password.text.toString()
        confirmPassword = et_confirm_password.text.toString()

        return when {
            userName.isEmpty() -> {
                Toast.makeText(this, "Name could not be empty", Toast.LENGTH_LONG).show()
                false
            }
            phone.isEmpty() -> {
                Toast.makeText(this, "Password could not be empty", Toast.LENGTH_LONG).show()
                false
            }
            email.isEmpty() -> {
                Toast.makeText(this, "Email could not be empty", Toast.LENGTH_LONG).show()
                false
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Password could not be empty", Toast.LENGTH_LONG).show()
                false
            }
            confirmPassword.isEmpty() -> {
                Toast.makeText(this, "Confirm Password could not be empty", Toast.LENGTH_LONG)
                    .show()
                false
            }

            password != confirmPassword -> {
                Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show()
                false
            }
            else -> true
        }
    }

    private fun signupForm() {

        parameters.clear()
        parameters["username"] = userName
//        parameters["phone"] = phone
        parameters["email"] = email
        parameters["password"] = password
        parameters["repeat_password"] = confirmPassword


        signInUpViewModel.signupForm(parameters).observe(this, Observer { signinDataContainer ->
            run {

                signinDataContainer?.let {
                    saveString(AppConstants.TOKEN, it.getSessionToken().toString())
                    Toast.makeText(this@SignupActivity, it.getMessage(), Toast.LENGTH_SHORT).show()
                    Log.d(TAG, it.getMessage())
                }
            }
        })
    }
}
