package com.example.dacaco.views.creation

import BackgroundFragment
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.views.creation.fragments.ExperienceFragment
import com.example.dacaco.views.creation.fragments.OriginFragment
import com.example.dacaco.views.creation.fragments.RoleFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class CreationActivity : AppCompatActivity() {
    private lateinit var mBottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creation)

        loadFragment(OriginFragment())

        mBottomNavigationView = findViewById(R.id.creation_navigation)
        mBottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment? = when (item.itemId) {
                R.id.creation_menu_homeworld -> OriginFragment()
                R.id.creation_menu_background -> BackgroundFragment()
                R.id.creation_menu_role -> RoleFragment()
                R.id.creation_menu_px -> ExperienceFragment()
                else -> null
            }
            loadFragment(fragment)
        }

    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.creation_fragment_layout, fragment).commit()
            return true
        }
        return false
    }
}