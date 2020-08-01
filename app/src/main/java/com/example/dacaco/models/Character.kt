package com.example.dacaco.models

import com.example.dacaco.utils.Aptitude
import com.example.dacaco.utils.Char

class Character(var name: String) {
    var homeworld: String = ""
    var background: String = ""
    var characteristics: Array<Characteristic> = arrayOf(
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
    var aptitudes: Array<Aptitude> = arrayOf()
}