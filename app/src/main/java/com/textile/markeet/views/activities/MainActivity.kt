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
                R.id.navigation_dashboard -> {
                    textMessage.setText(R.string.title_dashboard)
                    startActivity(Intent(this, SignupActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    textMessage.setText(R.string.title_notifications)
                    startActivity(Intent(this, ParentCategoriesListActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
