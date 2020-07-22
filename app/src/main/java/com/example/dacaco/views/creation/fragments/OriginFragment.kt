package com.example.dacaco.views.creation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.models.Homeworld
import com.example.dacaco.utils.Dice
import com.google.android.material.textfield.TextInputLayout

class OriginFragment : Fragment() {
    private lateinit var mOriginSelect: TextInputLayout
    private lateinit var mOriginAutoCompleteTextView: AutoCompleteTextView
    private lateinit var mOriginBtn: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_origin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mOriginSelect = view.findViewById(R.id.origin_select_world)
        val items: List<String> = Homeworld.worlds.map { resources.getString(it.title) }
        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, items)
        mOriginAutoCompleteTextView = view.findViewById(R.id.origin_select_world_autocomplete)
        mOriginAutoCompleteTextView.setAdapter(adapter)

        mOriginBtn = view.findViewById(R.id.origin_select_world_dice)
        mOriginBtn.setOnClickListener {
            val dice: Int = Dice.throw1dN(100)
            for ((index, world) in Homeworld.worlds.withIndex()) {
                if (world.luck >= dice) {
                    mOriginAutoCompleteTextView.setText(items[index], false)
                    break
                }
            }
        }
    }
}