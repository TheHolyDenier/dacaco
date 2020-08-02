package com.example.dacaco.views.creation.fragments.listeners

import android.text.Editable
import android.text.TextWatcher
import com.example.dacaco.views.creation.fragments.BackgroundFragment

class BackgroundTextWatcher(val fragment: BackgroundFragment) : TextWatcher {
    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        fragment.selectBackground()
    }

}
