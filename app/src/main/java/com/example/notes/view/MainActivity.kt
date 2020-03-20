package com.example.notes.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.callingapp.viewModel.MainActivityViewModel
import com.example.notes.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationBottomViewClickListener)

        if (savedInstanceState == null) {
            val fragment = Fragment1()
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                .commit()
        }
    }

    private val onNavigationBottomViewClickListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_blog -> {
                    val fragment = Fragment1()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_chapter -> {
                    val fragment = Fragment1()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}
