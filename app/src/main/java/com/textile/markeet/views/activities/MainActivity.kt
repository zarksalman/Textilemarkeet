package com.textile.markeet.views.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.textile.markeet.R
import com.textile.markeet.helpers.AppConstants

class MainActivity : BaseActivity() {

    private lateinit var textMessage: TextView

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    textMessage.setText(R.string.title_home)

                    startActivity(Intent(this, SigninActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_account -> {
                    textMessage.setText(R.string.account)
                    startActivity(Intent(this, SignupActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_about_us -> {
                    textMessage.setText(R.string.about_us)
                    startActivity(Intent(this, ParentCategoriesListActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_contact_us -> {
                    textMessage.setText(R.string.contact_us)
                    startActivity(Intent(this, ParentCategoriesListActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setLayout(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
