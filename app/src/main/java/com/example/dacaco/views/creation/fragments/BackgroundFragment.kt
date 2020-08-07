package com.example.dacaco.views.creation.fragments

import android.app.ActionBar
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.databinding.FragmentBackgroundBinding
import com.example.dacaco.models.Background
import com.example.dacaco.models.SecondStep
import com.example.dacaco.utils.CharacterSingleton
import com.example.dacaco.utils.Dice
import com.example.dacaco.utils.Skills
import com.example.dacaco.utils.Talents
import com.example.dacaco.views.creation.dialogs.BackgroundDialogFragment
import com.example.dacaco.views.creation.fragments.listeners.BackgroundTextWatcher
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import java.util.*

//TODO: Upload from singleton

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
        binding.autocomplete.setAdapter(adapter)

        binding.autocomplete.addTextChangedListener(BackgroundTextWatcher(this))
        binding.diceBtn.setOnClickListener {
            getBackgroundByLuck()
        }
        binding.infoBtn.setOnClickListener { openInfoDialog() }
    }

    private fun openInfoDialog() {
        if (binding.background != null) {
            val f = BackgroundDialogFragment()
            val args = Bundle()
            args.putInt("index", getPosition())
            f.arguments = args
            f.show(childFragmentManager, "dialog")
        }
    }

    private fun getBackgroundByLuck() {
        val dice: Int = Dice.throw1dN(items.size) - 1
        binding.autocomplete.setText(items[dice], false)
    }

    fun selectBackground() {
        if (binding.autocomplete.text.toString().isNotEmpty()) {
            val position: Int = getPosition()
            val background = Background.backgrounds[position]
            binding.background = background
            setChooseBetween(Background.backgrounds[position], context!!)
            CharacterSingleton.secondStep = SecondStep()
            CharacterSingleton.secondStep.background = binding.autocomplete.text.toString()
            CharacterSingleton.secondStep.skills = background.skills
            CharacterSingleton.secondStep.talents = background.talents
            CharacterSingleton.secondStep.bonus.add(background.bonus)
            if (background.other != null) CharacterSingleton.secondStep.bonus.add(background.other)
            CharacterSingleton.secondStep.aptitudes = background.aptitudes
        }
    }

    private fun getPosition(): Int = items.indexOf(binding.autocomplete.text.toString())


    private fun setChooseBetween(background: Background, context: Context) {
        if (background.betweenSkills.isNotEmpty()) {
            betweenSkills(
                background,
                context
            )
            binding.skillsLayout.visibility = View.VISIBLE
        } else binding.skillsLayout.visibility = View.GONE
        if (background.betweenTalents.isNotEmpty()) {
            betweenTalents(
                background,
                context
            )
            binding.talentsLayout.visibility = View.VISIBLE
        } else binding.talentsLayout.visibility = View.GONE
    }

    private fun betweenSkills(
        background: Background,
        context: Context
    ) {
        binding.layoutChoseBetweenSkills.removeAllViews()
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
            CharacterSingleton.secondStep.skills.add(skill.first)
            group.addView(buttonFirst)
            group.check(buttonFirst.id)
            group.addOnButtonCheckedListener { _, id, isChecked ->
                selectNewSkill(
                    skill,
                    id,
                    buttonFirst,
                    isChecked
                )
            }
            group.addView(buttonSecond)
            binding.layoutChoseBetweenSkills.addView(group)
        }
    }

    private fun selectNewSkill(
        skill: Pair<Skills, Skills>,
        id: Int,
        buttonFirst: MaterialButton,
        checked: Boolean
    ) {
        val first =
            CharacterSingleton.secondStep.skills.indexOfFirst { it.id == skill.first.id }
        val second =
            CharacterSingleton.secondStep.skills.indexOfFirst { it.id == skill.second.id }
        if ((id == buttonFirst.id && checked) || (id != buttonFirst.id && !checked)) {
            if (first == -1 && second != -1) {
                CharacterSingleton.secondStep.skills.removeAt(second)
                CharacterSingleton.secondStep.skills.add(skill.first)
            }
            Toast.makeText(context, getString(skill.first.id), Toast.LENGTH_SHORT).show()
        } else {
            if (second == -1 && first != -1) {
                CharacterSingleton.secondStep.skills.removeAt(first)
                CharacterSingleton.secondStep.skills.add(skill.second)
            }
            Toast.makeText(context, getString(skill.second.id), Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectNewTalent(
        talent: Pair<Talents, Talents>,
        id: Int,
        buttonFirst: MaterialButton, checked: Boolean
    ) {
        val first =
            CharacterSingleton.secondStep.talents.indexOfFirst { it.id == talent.first.id }
        val second =
            CharacterSingleton.secondStep.talents.indexOfFirst { it.id == talent.second.id }
        if ((id == buttonFirst.id && checked) || (id != buttonFirst.id && !checked)) {
            if (first == -1 && second != -1) {
                CharacterSingleton.secondStep.talents.removeAt(second)
                CharacterSingleton.secondStep.talents.add(talent.first)
            }
            Toast.makeText(context, getString(talent.first.id), Toast.LENGTH_SHORT).show()
        } else {
            if (second == -1 && first != -1) {
                CharacterSingleton.secondStep.talents.removeAt(first)
                CharacterSingleton.secondStep.talents.add(talent.second)
            }
            Toast.makeText(context, getString(talent.second.id), Toast.LENGTH_SHORT).show()
        }
    }

    private fun betweenTalents(
        background: Background,
        context: Context
    ) {
        binding.layoutChoseBetweenTalents.removeAllViews()
        for (talent in background.betweenTalents) {
            val group = MaterialButtonToggleGroup(context)
            val params = ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
            group.layoutParams = params
            group.isSingleSelection = true
            group.isSelectionRequired = true
            val buttonFirst: MaterialButton = setButton(context, talent.first.id)
            val buttonSecond: MaterialButton = setButton(context, talent.second.id)
            group.addView(buttonFirst)
            group.check(buttonFirst.id)
            group.addOnButtonCheckedListener { _, id, isChecked ->
                selectNewTalent(
                    talent,
                    id,
                    buttonFirst,
                    isChecked
                )
            }
            CharacterSingleton.secondStep.talents.add(talent.first)
            group.addView(buttonSecond)
            binding.layoutChoseBetweenTalents.addView(group)
        }
    }


    private fun setButton(
        context: Context,
        id: Int
    ): MaterialButton {
        val button =
            MaterialButton(context, null, R.attr.materialButtonOutlinedStyle)
        button.text = getString(id).toUpperCase(Locale.ROOT)
        button.maxLines = 1


        val params = LinearLayout.LayoutParams(
            0,
            ActionBar.LayoutParams.WRAP_CONTENT,
            1.0f
        )

        params.setMargins(
            resources.getDimension(R.dimen.half_horizontal).toInt(),
            resources.getDimension(R.dimen.vertical).toInt(),
            resources.getDimension(R.dimen.half_horizontal).toInt(),
            0
        )

        button.layoutParams = params
        return button
    }
}