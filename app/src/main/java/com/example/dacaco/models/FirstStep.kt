package com.example.dacaco.models

import com.example.dacaco.utils.Aptitudes
import com.example.dacaco.utils.Char
import com.example.dacaco.utils.Talents

class FirstStep {
    var homeworld: String = ""
    var characteristics: ArrayList<Characteristic> = arrayListOf(
        Characteristic(Char.WEAPON_SKILL),
        Characteristic(Char.BALLISTIC_SKILL),
        Characteristic(Char.STRENGTH),
        Characteristic(Char.TOUGHNESS),
        Characteristic(Char.AGILITY),
        Characteristic(Char.INTELLIGENCE),
        Characteristic(Char.PERCEPTION),
        Characteristic(Char.WILLPOWER),
        Characteristic(Char.FELLOWSHIP),
        Characteristic(Char.INFLUENCE)
    )
    var wounds: Int = 0
    var fateThreshold: Int = 0
    var aptitudes: ArrayList<Aptitudes> = arrayListOf()
    var talents: ArrayList<Talents> = arrayListOf()

}