package com.example.dacaco.views.creation.dialogs

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.dacaco.R
import com.example.dacaco.databinding.FragmentDialogBackgroundBinding
import com.example.dacaco.models.Background

class BackgroundDialogFragment : DialogFragment() {
    private lateinit var background: Background
    private lateinit var binding: FragmentDialogBackgroundBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_background, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        background = Background.backgrounds[arguments?.getInt("index", 0)!!]
        if (background == null) dismiss()

        binding.title.text = getString(background.title.id).toEditable()

        if (background.skills.isEmpty()) binding.skillsLayout.visibility = View.GONE
        if (background.talents.isEmpty()) binding.talentsLayout.visibility = View.GONE

        binding.bonus.text = String.format(
            "%s: %s",
            getString(background.bonus.title),
            getString(background.bonus.summary)
        ).toEditable()


        if (background.other != null)
            binding.other.text = String.format(
                "%s: %s",
                getString(background.other!!.title),
                getString(background.other!!.summary)
            ).toEditable()
        else binding.otherLayout.visibility = View.GONE

        binding.btn.setOnClickListener { dismiss() }
        setSkills()
        setTalents()
        setAptitudes()
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun setAptitudes() {
        var aptitudes = ""
        for ((i, aptitude) in background.aptitudes.withIndex()) {
            if (i != 0) aptitudes += ", "
            aptitudes += getString(aptitude.id)
        }
        binding.aptitudes.text = aptitudes
    }

    private fun setTalents() {
        var talents = ""
        for ((i, talent) in background.talents.withIndex()) {
            if (i != 0) talents += ", "
            talents += getString(talent.id)
        }
        binding.talents.text = talents
    }

    private fun setSkills() {
        var skills = ""
        for ((i, skill) in background.skills.withIndex()) {
            if (i != 0) skills += ", "
            skills += getString(skill.id)
        }
        binding.skills.text = skills
    }
}