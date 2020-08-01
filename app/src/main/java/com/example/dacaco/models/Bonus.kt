package com.example.dacaco.models

import com.example.dacaco.utils.Talents

class Bonus(
    val title: Int,
    val summary: Int,
    val choseBetween: Boolean = false,
    val talentsOne: Talents? = null,
    val talentsTwo: Talents? = null
)