package com.example.dacaco.models

import com.example.dacaco.R
import com.example.dacaco.utils.*
import com.example.dacaco.utils.Char

class Homeworld(
    val title: Int,
    val luck: Int,
    val characteristicModifiers: CharacteristicModifiers,
    val fateThreshold: FateThreshold,
    val bonus: Bonus,
    val aptitudes: Aptitudes,
    val wounds: Dice,
    val backgrounds: List<Backgrounds>
) {
    companion object {
        private val FeralWorld = Homeworld(
            R.string.feral_world,
            15,
            CharacteristicModifiers(
                Char.STRENGTH,
                Char.TOUGHNESS,
                Char.INFLUENCE
            ),
            FateThreshold(2, 3),
            Bonus(R.string.the_old_ways_title, R.string.the_old_ways_summary),
            Aptitudes.TOUGHNESS,
            Dice(1, 5, 9),
            listOf(
                Backgrounds.ADEPTUS_ARBITES,
                Backgrounds.ADEPTUS_ASTRA_TELEPATHICA,
                Backgrounds.IMPERIAL_GUARD,
                Backgrounds.OUTCAST
            )
        )
        private val ForgeWorld = Homeworld(
            R.string.forge_world,
            33,
            CharacteristicModifiers(
                Char.INTELLIGENCE, Char.TOUGHNESS, Char.FELLOWSHIP
            ),
            FateThreshold(3, 8),
            Bonus(
                R.string.omnissiahs_chosen_title,
                R.string.omnissiahs_chosen_summary,
                true,
                Talents.TECHNICAL_KNOCK,
                Talents.WEAPON_TECH
            ),
            Aptitudes.INTELLIGENCE,
            Dice(1, 5, 8),
            listOf(
                Backgrounds.ADEPTUS_ADMINISTRATUM,
                Backgrounds.ADEPTUS_ARBITES,
                Backgrounds.ADEPTUS_MECHANICUS,
                Backgrounds.IMPERIAL_GUARD
            )
        )

        private val Highborn = Homeworld(
            R.string.highborn,
            44,
            CharacteristicModifiers(
                Char.FELLOWSHIP,
                Char.INFLUENCE,
                Char.TOUGHNESS
            ),
            FateThreshold(4, 10),
            Bonus(R.string.breeding_counts_title, R.string.breeding_counts_summary),
            Aptitudes.FELLOWSHIP,
            Dice(1, 5, 9),
            listOf(
                Backgrounds.ADEPTUS_ADMINISTRATUM,
                Backgrounds.ADEPTUS_ARBITES,
                Backgrounds.ADEPTUS_ASTRA_TELEPATHICA,
                Backgrounds.ADEPTUS_MINISTORUM
            )
        )

        private val HiveWorld = Homeworld(
            R.string.hive_world,
            69,
            CharacteristicModifiers(
                Char.AGILITY, Char.PERCEPTION, Char.WILLPOWER
            ),
            FateThreshold(2, 6),
            Bonus(R.string.teeming_masses_title, R.string.teeming_masses_summary),
            Aptitudes.PERCEPTION,
            Dice(1, 5, 8),
            listOf(
                Backgrounds.ADEPTUS_ARBITES,
                Backgrounds.ADEPTUS_MECHANICUS,
                Backgrounds.IMPERIAL_GUARD,
                Backgrounds.OUTCAST
            )
        )

        private val ShrineWorld = Homeworld(
            R.string.shrine_world,
            85,
            CharacteristicModifiers(
                Char.FELLOWSHIP, Char.WILLPOWER, Char.PERCEPTION
            ),
            FateThreshold(3, 6),
            Bonus(R.string.faith_in_the_creed_title, R.string.faith_in_the_creed_summary),
            Aptitudes.WILLPOWER,
            Dice(1, 5, 7),
            listOf(
                Backgrounds.ADEPTUS_ADMINISTRATUM,
                Backgrounds.ADEPTUS_ARBITES,
                Backgrounds.ADEPTUS_MINISTORUM,
                Backgrounds.IMPERIAL_GUARD
            )
        )

        private val VoidBorn = Homeworld(
            R.string.voidborn,
            100,
            CharacteristicModifiers(
                Char.INTELLIGENCE, Char.WILLPOWER, Char.STRENGTH
            ),
            FateThreshold(3, 5),
            Bonus(
                R.string.child_of_the_dark_title,
                R.string.child_of_the_dark_summary,
                true,
                Talents.STRONG_MINDED
            ),
            Aptitudes.INTELLIGENCE,
            Dice(1, 5, 7),
            listOf(
                Backgrounds.ADEPTUS_ASTRA_TELEPATHICA,
                Backgrounds.ADEPTUS_MECHANICUS,
                Backgrounds.ADEPTUS_MINISTORUM,
                Backgrounds.OUTCAST
            )
        )

        val worlds: List<Homeworld> =
            listOf(FeralWorld, ForgeWorld, Highborn, HiveWorld, ShrineWorld, VoidBorn)
    }

    override fun toString(): String {
        return title.toString()
    }
}