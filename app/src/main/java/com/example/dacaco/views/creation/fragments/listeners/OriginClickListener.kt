package com.example.dacaco.views.creation.fragments.listeners

import android.view.View
import com.example.dacaco.R
import com.example.dacaco.views.creation.fragments.OriginFragment


class OriginClickListener(val fragment: OriginFragment) : View.OnClickListener {
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.origin_select_world_dice -> fragment.genOriginByLuck()
            R.id.origin_select_world_info -> fragment.openDialogHomeworldInfo()
        }
    }

}