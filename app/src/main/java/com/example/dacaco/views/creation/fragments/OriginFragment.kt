package com.example.dacaco.views.creation.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.databinding.FragmentOriginBinding
import com.example.dacaco.models.FirstStep
import com.example.dacaco.models.Homeworld
import com.example.dacaco.utils.CharacterSingleton
import com.example.dacaco.utils.Dice
import com.example.dacaco.utils.Talents
import com.example.dacaco.views.creation.dialogs.OriginDialogFragment
import com.example.dacaco.views.creation.fragments.listeners.OriginTextWatcher
import com.google.android.material.textfield.TextInputLayout


class OriginFragment : Fragment() {

    private lateinit var binding: FragmentOriginBinding
    private lateinit var items: List<String>
    private var charBaseValue: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_origin, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        items = Homeworld.worlds.map { resources.getString(it.title) }
        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, items)
        binding.originSelectWorldAutocomplete.setAdapter(adapter)

        binding.originSelectWorldDice.setOnClickListener { genOriginByLuck() }
        binding.originSelectWorldInfo.setOnClickListener { openDialogHomeworldInfo() }
        binding.originRandomCharacteristics.setOnClickListener { showHideRandomCharacteristics() }
        binding.originWoundsDice.setOnClickListener { setRandomWounds() }
        binding.originCharacteristicsDice.setOnClickListener { throwDices() }
        binding.originSelectWorldAutocomplete.addTextChangedListener(OriginTextWatcher(this))
        binding.originWoundsInput.addTextChangedListener(OriginTextWatcher(this))
        binding.originFateThresholdDice.setOnClickListener { throwFateThresholdDice() }
        binding.originFateThresholdSwitch.setOnCheckedChangeListener { _, _ -> updateFateThreshold() }

        setTextWatchCharacters()
    }

    fun updateFateThreshold() {
        CharacterSingleton.firstStep.fateThreshold =
            binding.world?.fateThreshold?.fate?.plus(
                if (binding.originFateThresholdSwitch.isChecked) 1
                else 0
            )!!
    }

    private fun throwFateThresholdDice() {
        binding.originFateThresholdSwitch.isChecked =
            Dice.throw1dN(10) >= binding.world?.fateThreshold?.difficult!!
    }

    private fun setTextWatchCharacters() {
        for (textInputLayout in binding.originCharLayout.children) {
            if (textInputLayout is TextInputLayout) {
                textInputLayout.editText?.addTextChangedListener(OriginTextWatcher(this))
            }
        }
    }

    fun updateSuffix() {
        var totalPoints = 0
        var i = 0
        for (textInputLayout in binding.originCharLayout.children) {
            if (textInputLayout is TextInputLayout) {
                val prefix = textInputLayout.prefixText.toString().split(' ')[0].toInt()
                val value =
                    if (textInputLayout.editText?.text.toString().isBlank()) 0
                    else textInputLayout.editText?.text.toString().toInt()
                totalPoints += value
                val valueTotal = prefix.plus(value)
                textInputLayout.suffixText = " = $valueTotal"
                CharacterSingleton.firstStep.characteristics[i].value = valueTotal
            }
            i++
        }
        binding.originCharacteristicsPoints.text =
            getString(R.string.restant_char_points, totalPoints, 60)
    }

    private fun throwDices() {
        for (textInputLayout in binding.originCharLayout.children) {
            if (textInputLayout is TextInputLayout) {
                val finalValue: String = when (textInputLayout.hint.toString()) {
                    getString(binding.world!!.characteristicModifiers.positiveFirst.id) -> {
                        val dices = Dice.throwIdN(3, 10)
                        "${dices.sum() - dices.min()!!}"
                    }
                    getString(binding.world!!.characteristicModifiers.positiveSecond.id) -> {
                        val dices = Dice.throwIdN(3, 10)
                        "${dices.sum() - dices.min()!!}"
                    }
                    getString(binding.world!!.characteristicModifiers.negative.id) -> {
                        val dices = Dice.throwIdN(3, 10)
                        "${dices.sum() - dices.max()!!}"
                    }
                    else -> {
                        "${Dice.throwIdN(2, 10).sum()}"
                    }
                }
                textInputLayout.editText?.text = getEditable(finalValue)
            }
        }
    }

    private fun setRandomWounds() {
        val result: Int = Dice.throw1dN(binding.world!!.wounds.diceSides)
        binding.originWoundsInput.text = Editable.Factory.getInstance().newEditable("$result")

    }

    fun updateTotalWoundsSuffix() {
        val result: Int = if (binding.originWoundsInput.text.toString().isEmpty()) 0
        else binding.originWoundsInput.text.toString().toInt()
        val totalWounds = binding.world!!.wounds.modifier + result
        binding.originWoundsInputLayout.suffixText = "= $totalWounds"
        CharacterSingleton.firstStep.wounds = totalWounds
    }

    private fun showHideRandomCharacteristics() {
        val random = binding.originRandomCharacteristics.isChecked
        binding.originCharacteristicsDice.visibility = if (random) View.VISIBLE else View.INVISIBLE
        binding.originCharacteristicsPoints.visibility =
            if (!random) View.VISIBLE else View.INVISIBLE
        charBaseValue = if (random) 20 else 25
        updateCharacteristicsInputs(random)
    }

    private fun updateCharacteristicsInputs(isRandom: Boolean) {
        for (textInputLayout in binding.originCharLayout.children) {
            if (textInputLayout is TextInputLayout) {
                textInputLayout.prefixText = if (isRandom) {
                    getEditable("$charBaseValue + ")
                } else {
                    when (textInputLayout.hint.toString()) {
                        getString(binding.world!!.characteristicModifiers.positiveFirst.id) ->
                            getEditable("${charBaseValue.plus(5)} + ")
                        getString(binding.world!!.characteristicModifiers.positiveSecond.id) ->
                            getEditable("${charBaseValue.plus(5)} + ")
                        getString(binding.world!!.characteristicModifiers.negative.id) ->
                            getEditable("${charBaseValue.minus(5)} + ")
                        else -> getEditable("$charBaseValue + ")
                    }
                }
            }
        }
    }

    private fun getEditable(text: String) =
        Editable.Factory.getInstance().newEditable(text)

    private fun genOriginByLuck() {
        val dice: Int = Dice.throw1dN(100)
        for ((index, world) in Homeworld.worlds.withIndex()) {
            if (world.luck >= dice) {
                binding.originSelectWorldAutocomplete.setText(items[index], false)
                binding.world = world
                break
            }
        }
        reloadDataHomeworld()
        showHideRandomCharacteristics()
    }

    private fun openDialogHomeworldInfo() {
        if (binding.originSelectWorldAutocomplete.text.toString().isNotEmpty()) {
            val fragmentManager = childFragmentManager
            val f = OriginDialogFragment()
            val args = Bundle()
            args.putInt("index", getOriginIndex())
            f.arguments = args

            f.show(fragmentManager, "dialog")
        }
    }

    private fun getOriginIndex(): Int {
        val title = binding.originSelectWorldAutocomplete.text
        for ((index, item) in items.withIndex()) {
            if (item.contentEquals(title)) {
                return index
            }
        }
        return 0
    }

    private fun reloadDataHomeworld() {
        val position: Int = items.indexOf(binding.originSelectWorldAutocomplete.text.toString())
        binding.world = Homeworld.worlds[position]
        updateCharacteristicsInputs(binding.originRandomCharacteristics.isChecked)
        CharacterSingleton.firstStep.homeworld = getString(Homeworld.worlds[position].title)
        CharacterSingleton.firstStep.aptitudes = arrayListOf(binding.world?.aptitudes!!)
        if (binding.world?.bonus?.choseBetween!!) {
            setTalentsHomeWorld()
        }
    }

    private fun setTalentsHomeWorld() {
        val talentsOne: Talents? = binding.world?.bonus?.talentsOne
        if (talentsOne != null) {
            binding.originHomeWorldBonusChooseFirstBtn.text = getString(talentsOne.id)
        } else {
            binding.originHomeWorldBonusChooseFirstBtn.visibility = View.GONE
        }
        val talentsTwo: Talents? = binding.world?.bonus?.talentsTwo
        if (talentsTwo != null) {
            binding.originHomeWorldBonusChooseSecondBtn.text = getString(talentsTwo.id)
        } else {
            binding.originHomeWorldBonusChooseSecondBtn.visibility = View.GONE
        }
        binding.originHomeWorldBonusChooseGroup.check(binding.originHomeWorldBonusChooseFirstBtn.id)
        binding.originHomeWorldBonusChooseGroup.addOnButtonCheckedListener { _, id, _ ->
            CharacterSingleton.firstStep.talents = arrayListOf(
                if (binding.originHomeWorldBonusChooseFirstBtn.id == id) {
                    talentsOne!!
                } else {
                    talentsTwo!!
                }
            )
        }
    }

    fun showInfo() {
        CharacterSingleton.firstStep = FirstStep()
        if (binding.originSelectWorldAutocomplete.text.toString().isNotEmpty()) {
            reloadDataHomeworld()
        }
    }
}