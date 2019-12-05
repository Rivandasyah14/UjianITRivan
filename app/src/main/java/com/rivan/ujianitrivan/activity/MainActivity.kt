package com.rivan.ujianitrivan.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rivan.ujianitrivan.R
import com.rivan.ujianitrivan.fragment.DessertFragment
import com.rivan.ujianitrivan.fragment.ProfileFragment
import com.rivan.ujianitrivan.fragment.SeafoodFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_seafood -> {
                    transactionSeafoodFragment(savedInstanceState)
                }
                R.id.action_dessert -> {
                    transactionDessertFragment(savedInstanceState)
                }
                R.id.action_profile -> {
                    transactionProfileFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_nav.selectedItemId = R.id.action_dessert
    }

    private fun transactionProfileFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fm_layout, ProfileFragment(),
                ProfileFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun transactionDessertFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fm_layout, DessertFragment(),
                DessertFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun transactionSeafoodFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fm_layout, SeafoodFragment(),
                SeafoodFragment::class.java.simpleName)
                .commit()
        }
    }
}
