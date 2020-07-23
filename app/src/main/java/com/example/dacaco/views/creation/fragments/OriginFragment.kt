package com.example.dacaco.views.creation.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.databinding.FragmentOriginBinding
import com.example.dacaco.models.Homeworld
import com.example.dacaco.utils.Dice
import com.example.dacaco.views.OriginDialogFragment


class OriginFragment : Fragment() {

    private lateinit var binding: FragmentOriginBinding
    private lateinit var items: List<String>
    private var world: Homeworld = Homeworld.worlds[0]

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
    }

    private fun setRandomWounds() {
        val result: Int = Dice.throw1dN(world.wounds.diceSides)
        binding.originWoundsInput.text = Editable.Factory.getInstance().newEditable("$result")
        binding.originWoundsInputLayout.suffixText = "= ${world.wounds.modifier + result}"
    }

    private fun showHideRandomCharacteristics() {
        val random = binding.originRandomCharacteristics.isChecked
        binding.originCharacteristicsDice.visibility = if (random) View.VISIBLE else View.INVISIBLE
        binding.originCharacteristicsPoints.visibility =
            if (!random) View.VISIBLE else View.INVISIBLE
        updateCharacteristicsInputs()
    }

    private fun updateCharacteristicsInputs() {

    }

    private fun genOriginByLuck() {
        val dice: Int = Dice.throw1dN(100)
        for ((index, world) in Homeworld.worlds.withIndex()) {
            if (world.luck >= dice) {
                binding.originSelectWorldAutocomplete.setText(items[index], false)
                binding.world = world
                break
            }
        }
    }

    private fun openDialogHomeworldInfo() {
        val fragmentManager = childFragmentManager
        val f = OriginDialogFragment()
        val args = Bundle()
        args.putInt("index", getOriginIndex())
        f.arguments = args

        f.show(fragmentManager, "dialog")

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

    fun showInfo() {
        if (binding.originSelectWorldAutocomplete.text.toString().isNotEmpty()) {
            binding.originLayout.visibility = View.VISIBLE
            reloadDataHomeworld()
        }
    }

    private fun reloadDataHomeworld() {
        val position: Int = items.indexOf(binding.originSelectWorldAutocomplete.text.toString())
        world = Homeworld.worlds[position]
    }
}