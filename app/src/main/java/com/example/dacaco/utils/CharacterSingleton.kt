package com.example.dacaco.utils

import com.example.dacaco.models.Character
import com.example.dacaco.models.FirstStep
import com.example.dacaco.models.SecondStep

class CharacterSingleton {
    companion object {
        var character: Character = Character()

        var firstStep: FirstStep = FirstStep()

        fun addFirstStep() {
            character.homeworld = firstStep.homeworld
            character.characteristics = firstStep.characteristics
            character.wounds = firstStep.wounds
            character.fateThreshold = firstStep.fateThreshold
            character.aptitudes.addAll(firstStep.aptitudes)
            character.talents.addAll(firstStep.talents)
        }

        var secondStep: SecondStep = SecondStep()

        fun addSecondStep() {
            character.background = secondStep.background
            character.aptitudes.addAll(secondStep.aptitudes)
            character.talents.addAll(secondStep.talents)
            character.skills.addAll(secondStep.skills)
            character.bonus.addAll(secondStep.bonus)
        }
    }
}