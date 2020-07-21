package com.example.dacaco.views

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dacaco.R
import kotlinx.coroutines.*


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        runBlocking { launch { launchActivity() } }
    }

    private suspend fun launchActivity() = withContext(Dispatchers.Default) {
        delay(1000)
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        intent.flags = FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
//        finish()

    }
}