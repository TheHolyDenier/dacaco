package com.example.dacaco.utils

import com.example.dacaco.models.Character
import com.example.dacaco.models.FirstStep

class CharacterSingleton {
    companion object {
        var character: Character = Character()

        var firstStep: FirstStep = FirstStep()
        fun addFirstStep (step: FirstStep) {
            character.homeworld = step.homeworld
            character.characteristics = step.characteristics
            character.wounds = step.wounds
            character.fateThreshold = step.fateThreshold
            character.aptitudes = character.aptitudes + step.aptitudes
            character.talents = character.talents + step.talents
        }
    }
}