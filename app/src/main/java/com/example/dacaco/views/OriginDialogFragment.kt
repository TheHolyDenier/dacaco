package com.example.dacaco.views

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dacaco.R
import com.example.dacaco.models.Homeworld

class OriginDialogFragment : DialogFragment() {

    private lateinit var mTitle: TextView
    private lateinit var mSummary: TextView
    private lateinit var mCharacteristicModifiers: TextView
    private lateinit var mFateThreshold: TextView
    private lateinit var mHomeworldBonus: TextView
    private lateinit var mAptitude: TextView
    private lateinit var mWounds: TextView
    private lateinit var mRecomendedBackgrounds: TextView
    private lateinit var mButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout to use as dialog or embedded fragment
        return inflater.inflate(R.layout.fragment_dialog_origin, container, false)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val index = arguments?.getInt("index", 0)
        if (index != null) {
            val homeworld = Homeworld.worlds[index]

            mTitle = view.findViewById(R.id.dialog_title)
            mTitle.text = activity?.resources?.getString(homeworld.title)

            mSummary = view.findViewById(R.id.dialog_body)
            if (Homeworld.worlds[index].description != null) {
                mSummary.text = context?.resources?.getString(homeworld.description!!)
            }

            mCharacteristicModifiers = view.findViewById(R.id.dialog_characteristic_modifiers)
            mCharacteristicModifiers.text = String.format(
                "+%s, +%s, -%s",
                resources.getString(homeworld.characteristicModifiers.positiveFirst.id),
                resources.getString(homeworld.characteristicModifiers.positiveSecond.id),
                resources.getString(homeworld.characteristicModifiers.negative.id)
            )

//            TODO: por aquí, scrollview???
            mFateThreshold = view.findViewById(R.id.dialog_fate_threshold)
            mHomeworldBonus = view.findViewById(R.id.dialog_homeworld_bonus)
            mAptitude = view.findViewById(R.id.dialog_aptitude)
            mWounds = view.findViewById(R.id.dialog_wounds)
            mRecomendedBackgrounds = view.findViewById(R.id.dialog_backgrounds)

            mButton = view.findViewById(R.id.dialog_btn)
            mButton.setOnClickListener { dismiss() }
        }
    }
}