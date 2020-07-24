package com.example.dacaco.models

import com.example.dacaco.utils.Talent

class HomeworldBonus(
    val title: Int,
    val summary: Int,
    val choseBetween: Boolean = false,
    val choseBetweenAptitudes: Pair<Talent, Talent>? = null
)