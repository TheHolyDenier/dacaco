package com.example.dacaco.views.creation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.dacaco.R
import com.example.dacaco.models.Homeworld
import com.example.dacaco.utils.Dice
import com.example.dacaco.views.OriginDialogFragment
import com.example.dacaco.views.creation.fragments.listeners.OriginClickListener

class OriginFragment : Fragment() {
    private lateinit var mOriginAutoCompleteTextView: AutoCompleteTextView
    private lateinit var mOriginBtn: ImageButton
    private lateinit var mOriginInfoBtn: ImageButton

    private lateinit var items: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_origin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        items = Homeworld.worlds.map { resources.getString(it.title) }
        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, items)
        mOriginAutoCompleteTextView = view.findViewById(R.id.origin_select_world_autocomplete)
        mOriginAutoCompleteTextView.setAdapter(adapter)

        mOriginBtn = view.findViewById(R.id.origin_select_world_dice)
        mOriginBtn.setOnClickListener(
            OriginClickListener(
                this@OriginFragment
            )
        )

        mOriginInfoBtn = view.findViewById(R.id.origin_select_world_info)
        mOriginInfoBtn.setOnClickListener(
            OriginClickListener(
                this@OriginFragment
            )
        )

    }

    fun genOriginByLuck() {
        val dice: Int = Dice.throw1dN(100)
        for ((index, world) in Homeworld.worlds.withIndex()) {
            if (world.luck >= dice) {
                mOriginAutoCompleteTextView.setText(items[index], false)
                break
            }
        }
    }

    fun openDialogHomeworldInfo() {
        val fragmentManager = childFragmentManager
        val f = OriginDialogFragment()
        val args = Bundle()
        args.putInt("index", getOriginIndex())
        f.arguments = args
        f.show(fragmentManager, "dialog")
    }

    private fun getOriginIndex(): Int {
        val title = mOriginAutoCompleteTextView.text
        for ((index, item) in items.withIndex()) {
            if (item.contentEquals(title)) {
                return index
            }
        }
        return 0
    }
}