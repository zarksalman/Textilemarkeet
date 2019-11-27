package com.textile.markeet.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.textile.markeet.R
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.m_tool_bar.view.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        setBasicUi()
        setClickListeners()
    }

    private fun setBasicUi() {
        signup_tool_bar.tv_screen_title.text = resources.getString(R.string.sign_up)
    }

    private fun setClickListeners() {

        signup_tool_bar.btn_back.setOnClickListener { onBackPressed() }
        btn_sign_up.setOnClickListener { }
        btn_fb_sign_up.setOnClickListener { }
        btn_google_sign_up.setOnClickListener { }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
