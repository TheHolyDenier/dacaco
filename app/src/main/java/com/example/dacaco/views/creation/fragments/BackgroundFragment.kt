package com.example.dacaco.views.creation.fragments

import android.app.ActionBar
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.databinding.FragmentBackgroundBinding
import com.example.dacaco.models.Background
import com.example.dacaco.views.creation.fragments.listeners.BackgroundTextWatcher
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import java.util.*


class BackgroundFragment : Fragment() {
    private lateinit var items: List<String>
    private lateinit var binding: FragmentBackgroundBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_background, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        items = Background.backgrounds.map { resources.getString(it.title.id) }
        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, items)
        binding.backgroundsAutocomplete.setAdapter(adapter)

        binding.backgroundsAutocomplete.addTextChangedListener(BackgroundTextWatcher(this))
    }

    fun selectBackground() {
        if (binding.backgroundsAutocomplete.text.toString().isNotEmpty()) {
            val position: Int = items.indexOf(binding.backgroundsAutocomplete.text.toString())
            binding.background = Background.backgrounds[position]
            setValues(Background.backgrounds[position], context!!)
        }
    }

    private fun setValues(background: Background, context: Context) {
        binding.layoutChoseBetween.removeAllViews()
        for (skill in background.betweenSkills) {
            val group = MaterialButtonToggleGroup(context)
            val params = ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
            group.layoutParams = params
            group.isSingleSelection = true
            group.isSelectionRequired = true
            val buttonFirst: MaterialButton = setButton(context, skill.first.id)
            val buttonSecond: MaterialButton = setButton(context, skill.second.id)
            group.addView(buttonFirst)
            group.check(buttonFirst.id)
            group.addView(buttonSecond)
            binding.layoutChoseBetween.addView(group)
        }
    }

    private fun setButton(
        context: Context,
        id: Int
    ): MaterialButton {
        val buttonFirst =
            MaterialButton(context, null, R.attr.materialButtonOutlinedStyle)
        buttonFirst.text = getString(id).toUpperCase(Locale.ROOT)
        val params = ActionBar.LayoutParams(
            ActionBar.LayoutParams.WRAP_CONTENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(
            resources.getDimension(R.dimen.half_horizontal).toInt(),
            resources.getDimension(R.dimen.vertical).toInt(),
            resources.getDimension(R.dimen.half_horizontal).toInt(),
            0
        )
        buttonFirst.layoutParams = params
        return buttonFirst
    }
}