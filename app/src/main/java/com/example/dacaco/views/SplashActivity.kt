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

        overridePendingTransition(R.anim.fade_out, R.anim.fade_in)

        setContentView(R.layout.activity_splash)

        GlobalScope.launch {
            launchActivity()
        }
    }


    private suspend fun launchActivity() = withContext(Dispatchers.Default) {
        delay(3000)
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}