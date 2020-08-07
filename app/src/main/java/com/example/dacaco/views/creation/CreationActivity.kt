package com.example.dacaco.views.creation

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.databinding.ActivityCreationBinding
import com.example.dacaco.utils.CharacterSingleton
import com.example.dacaco.utils.DialogCompanion
import com.example.dacaco.utils.MessageType
import com.example.dacaco.views.creation.fragments.BackgroundFragment
import com.example.dacaco.views.creation.fragments.ExperienceFragment
import com.example.dacaco.views.creation.fragments.OriginFragment
import com.example.dacaco.views.creation.fragments.RoleFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class CreationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.creationAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = CharacterSingleton.character?.name


        binding.creationNavigation.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment? = when (item.itemId) {
                R.id.creation_menu_homeworld -> OriginFragment()
                R.id.creation_menu_background -> BackgroundFragment()
                R.id.creation_menu_role -> RoleFragment()
                R.id.creation_menu_px -> ExperienceFragment()
                else -> null
            }
            loadFragment(fragment)
        }

        loadFragment(OriginFragment())
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.creation_fragment_layout, fragment).commit()
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_name_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> DialogCompanion.areYouSure(this)
            R.id.edit_name_item -> DialogCompanion.editName(this, layoutInflater)
            R.id.save_item -> Toast.makeText(
                this@CreationActivity,
                getString(R.string.WIP),
                Toast.LENGTH_SHORT
            ).show()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onBackPressed() {
        DialogCompanion.areYouSure(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(type: MessageType) {
        when (type) {
            MessageType.EditName -> supportActionBar?.title = CharacterSingleton.character?.name
            MessageType.OK -> finish()
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(event)
    }
}