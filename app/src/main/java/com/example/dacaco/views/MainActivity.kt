package com.example.dacaco.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dacaco.R
import com.example.dacaco.views.creation.CreationActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

   private lateinit var mFab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFab = findViewById(R.id.main_fab)
        mFab.setOnClickListener { startActivity(Intent(this@MainActivity, CreationActivity::class.java)) }
    }
}