package com.example.dacaco.models

import android.content.res.Resources
import com.example.dacaco.R
import com.example.dacaco.utils.Aptitude
import com.example.dacaco.utils.Background
import com.example.dacaco.utils.Characteristic
import com.example.dacaco.utils.Dice

class Homeworld(
    val title: Int,
    val luck: Int,
    val characteristicModifiers: CharacteristicModifiers,
    val fateThreshold: FateThreshold,
    val homeworldBonus: HomeworldBonus,
    val aptitude: Aptitude,
    val wounds: Dice,
    val backgrounds: List<Background>
) {
    companion object {
        private val FeralWorld = Homeworld(
            R.string.feral_world,
            15,
            CharacteristicModifiers(
                Characteristic.STRENGTH,
                Characteristic.TOUGHNESS,
                Characteristic.INFLUENCE
            ),
            FateThreshold(2, 3),
            HomeworldBonus(R.string.the_old_ways_title, R.string.the_old_ways_summary),
            Aptitude.TOUGHNESS,
            Dice(1, 5, 9),
            listOf(
                Background.ADEPTUS_ARBITES,
                Background.ADEPTUS_ASTRA_TELEPATHICA,
                Background.IMPERIAL_GUARD,
                Background.OUTCAST
            )
        )
        private val ForgeWorld = Homeworld(
            R.string.forge_world,
            33,
            CharacteristicModifiers(
                Characteristic.INTELLIGENCE, Characteristic.TOUGHNESS, Characteristic.FELLOWSHIP
            ),
            FateThreshold(3, 8),
            HomeworldBonus(R.string.omnissiahs_chosen_title, R.string.omnissiahs_chosen_summary),
            Aptitude.INTELLIGENCE,
            Dice(1, 5, 8),
            listOf(
                Background.ADEPTUS_ADMINISTRATUM,
                Background.ADEPTUS_ARBITES,
                Background.ADEPTUS_MECHANICUS,
                Background.IMPERIAL_GUARD
            )
        )

        private val Highborn = Homeworld(
            R.string.highborn,
            44,
            CharacteristicModifiers(
                Characteristic.FELLOWSHIP,
                Characteristic.INFLUENCE,
                Characteristic.TOUGHNESS
            ),
            FateThreshold(4, 10),
            HomeworldBonus(R.string.breeding_counts_title, R.string.breeding_counts_summary),
            Aptitude.FELLOWSHIP,
            Dice(1, 5, 9),
            listOf(
                Background.ADEPTUS_ADMINISTRATUM,
                Background.ADEPTUS_ARBITES,
                Background.ADEPTUS_ASTRA_TELEPATHICA,
                Background.ADEPTUS_MINISTORUM
            )
        )

        private val HiveWorld = Homeworld(
            R.string.hive_world,
            69,
            CharacteristicModifiers(
                Characteristic.AGILITY, Characteristic.PERCEPTION, Characteristic.WILLPOWER
            ),
            FateThreshold(2, 6),
            HomeworldBonus(R.string.teeming_masses_title, R.string.teeming_masses_summary),
            Aptitude.PERCEPTION,
            Dice(1, 5, 8),
            listOf(
                Background.ADEPTUS_ARBITES,
                Background.ADEPTUS_MECHANICUS,
                Background.IMPERIAL_GUARD,
                Background.OUTCAST
            )
        )

        private val ShrineWorld = Homeworld(
            R.string.shrine_world,
            85,
            CharacteristicModifiers(
                Characteristic.FELLOWSHIP, Characteristic.WILLPOWER, Characteristic.PERCEPTION
            ),
            FateThreshold(3, 6),
            HomeworldBonus(R.string.faith_in_the_creed_title, R.string.faith_in_the_creed_summary),
            Aptitude.WILLPOWER,
            Dice(1, 5, 7),
            listOf(
                Background.ADEPTUS_ADMINISTRATUM,
                Background.ADEPTUS_ARBITES,
                Background.ADEPTUS_MINISTORUM,
                Background.IMPERIAL_GUARD
            )
        )

        private val VoidBorn = Homeworld(
            R.string.voidborn,
            100,
            CharacteristicModifiers(
                Characteristic.INTELLIGENCE, Characteristic.WILLPOWER, Characteristic.STRENGTH
            ),
            FateThreshold(3, 5),
            HomeworldBonus(R.string.child_of_the_dark_title, R.string.child_of_the_dark_summary),
            Aptitude.INTELLIGENCE,
            Dice(1, 5, 7),
            listOf(
                Background.ADEPTUS_ASTRA_TELEPATHICA,
                Background.ADEPTUS_MECHANICUS,
                Background.ADEPTUS_MINISTORUM,
                Background.OUTCAST
            )
        )

        val worlds: List<Homeworld> =
            listOf(FeralWorld, ForgeWorld, Highborn, HiveWorld, ShrineWorld, VoidBorn)
    }

    override fun toString(): String {
        return title.toString()
    }
}