package com.example.dacaco.models

import com.example.dacaco.R
import com.example.dacaco.utils.Aptitude
import com.example.dacaco.utils.Background
import com.example.dacaco.utils.Characteristic
import com.example.dacaco.utils.Dice

class Homeworld(
    val id: Int,
    val title: Int,
    val description: Int?,
    val image: Int?,
    val luck: Int,
    val characteristicModifiers: CharacteristicModifiers,
    val fateThreshold: FateThreshold,
    val homeworldBonus: HomeworldBonus,
    val aptitude: Aptitude,
    val wounds: Dice,
    val backgrounds: List<Background>
) {
    companion object {
        val FeralWorld = Homeworld(
            0,
            R.string.feral_world,
            null,
            null,
            74,
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
        val ForgeWorld = Homeworld(
            1,
            R.string.forge_world,
            null,
            null,
            59,
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

        val Highborn = Homeworld(
            2,
            R.string.highborn,
            null,
            null,
            100,
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

        val HiveWorld = Homeworld(
            3,
            R.string.hive_world,
            null, null,
            41,
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

        val ShrineWorld = Homeworld(
            4,
            R.string.shrine_world,
            null, null,
            16,
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
    }
}