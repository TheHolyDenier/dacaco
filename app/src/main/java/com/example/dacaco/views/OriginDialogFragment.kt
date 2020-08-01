package com.example.dacaco.views

import android.app.ActionBar
import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.dacaco.R
import com.example.dacaco.models.Homeworld
import com.example.dacaco.utils.Backgrounds


class OriginDialogFragment : DialogFragment() {

    private lateinit var mTitle: TextView
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

            mCharacteristicModifiers = view.findViewById(R.id.dialog_characteristic_modifiers)
            mCharacteristicModifiers.text = String.format(
                "+%s +%s -%s",
                resources.getString(homeworld.characteristicModifiers.positiveFirst.id),
                resources.getString(homeworld.characteristicModifiers.positiveSecond.id),
                resources.getString(homeworld.characteristicModifiers.negative.id)
            )

            mFateThreshold = view.findViewById(R.id.dialog_fate_threshold)
            mFateThreshold.text = resources.getString(
                R.string.fate_threshold_values,
                homeworld.fateThreshold.fate,
                homeworld.fateThreshold.difficult
            )

            mHomeworldBonus = view.findViewById(R.id.dialog_homeworld_bonus)
            mHomeworldBonus.text = resources.getString(
                R.string.homeworld_bonus_values,
                resources.getString(homeworld.bonus.title),
                resources.getString(homeworld.bonus.summary)
            )

            mAptitude = view.findViewById(R.id.dialog_aptitude)
            mAptitude.text = resources.getString(homeworld.aptitudes.id)

            mWounds = view.findViewById(R.id.dialog_wounds)
            mWounds.text = resources.getString(
                R.string.wounds_values,
                homeworld.wounds.modifier,
                homeworld.wounds.dices,
                homeworld.wounds.diceSides
            )

            mRecomendedBackgrounds = view.findViewById(R.id.dialog_backgrounds)
            mRecomendedBackgrounds.text = getBackgrounds(homeworld.backgrounds)

            mButton = view.findViewById(R.id.dialog_btn)
            mButton.setOnClickListener { dismiss() }
        }

        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ActionBar.LayoutParams.MATCH_PARENT
        params.height = ActionBar.LayoutParams.MATCH_PARENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams

    }

    private fun getBackgrounds(backgrounds: List<Backgrounds>): CharSequence? {
        var text = ""
        for ((index, background) in backgrounds.withIndex()) {
            text += resources.getString(background.id)
            if (index != backgrounds.size - 1) text += ", "
        }
        return text
    }
}