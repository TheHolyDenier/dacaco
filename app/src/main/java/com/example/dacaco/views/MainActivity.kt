package com.example.dacaco.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.dacaco.R
import com.example.dacaco.databinding.ActivityMainBinding
import com.example.dacaco.utils.DialogCompanion
import com.example.dacaco.utils.MessageType
import com.example.dacaco.views.creation.CreationActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.creationAppBar)
        supportActionBar?.title = getString(R.string.app_name)

        binding.mainFab.setOnClickListener { DialogCompanion.editName(this, layoutInflater) }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(type: MessageType) {
        if (type == MessageType.EditName)
            startActivity(
                Intent(
                    this@MainActivity,
                    CreationActivity::class.java
                )
            )
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(event)
    }
}