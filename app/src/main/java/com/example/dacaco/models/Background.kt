package com.example.dacaco.models

import com.example.dacaco.R
import com.example.dacaco.utils.Aptitudes
import com.example.dacaco.utils.Backgrounds
import com.example.dacaco.utils.Skills
import com.example.dacaco.utils.Talents

class Background(
    val title: Backgrounds,
    val betweenSkills: Array<Pair<Skills, Skills>>,
    val skills: Array<Skills>,
    val talents: Array<Talents>,
    val betweenTalents: Array<Pair<Talents, Talents>>,
    val bonus: Bonus,
    val aptitudes: Array<Aptitudes>,
    val other: Bonus? = null
) {
    companion object {
        val adeptusAdministratum = Background(
            Backgrounds.ADEPTUS_ADMINISTRATUM,
            arrayOf(Pair(Skills.COMMERCE, Skills.MEDICAE)),
            arrayOf(
                Skills.LINGUISTICS,
                Skills.LOGIC,
                Skills.SCHOLASTIC_LORE,
                Skills.CL_ADEPTUS_ADMINISRATUM
            ),
            arrayOf(),
            arrayOf(
                Pair(
                    Talents.WT_LAS,
                    Talents.WT_SOLID_PROJECTILE
                )
            ),
            Bonus(R.string.master_of_paperwork_title, R.string.master_of_paperwork_description),
            arrayOf(
                Aptitudes.KNOWLEDGE, Aptitudes.SOCIAL
            )
        )
        val adeptusArbites = Background(
            Backgrounds.ADEPTUS_ARBITES,
            arrayOf(Pair(Skills.INQUIRY, Skills.INTERROGATION)),
            arrayOf(
                Skills.SCRUTINY,
                Skills.INTIMIDATE,
                Skills.AWARENESS,
                Skills.CL_ADEPTUS_ARBITES,
                Skills.CL_UNDERWORLD
            ),
            arrayOf(),
            arrayOf(Pair(Talents.WT_SOLID_PROJECTILE, Talents.WT_SHOCK)),
            Bonus(R.string.the_face_of_the_law_title, R.string.the_face_of_the_law_description),
            arrayOf(Aptitudes.OFFENCE, Aptitudes.DEFENCE)
        )

        val adeptusAstraTelepathica = Background(
            Backgrounds.ADEPTUS_ASTRA_TELEPATHICA,
            arrayOf(
                Pair(Skills.DECEIVE, Skills.INTERROGATION),
                Pair(Skills.PSYNISCIENCE, Skills.SCRUTINY)
            ),
            arrayOf(Skills.AWARENESS, Skills.CL_ADEPTUS_ASTRA_TELEPATHICA, Skills.FL_WARP),
            arrayOf(),
            arrayOf(Pair(Talents.WT_LAS, Talents.LOW_TECH)),
            Bonus(R.string.constant_thread_title, R.string.constant_thread_description),
            arrayOf(Aptitudes.DEFENCE, Aptitudes.PSYKER),
            Bonus(R.string.tested_on_terra_title, R.string.tested_on_terra_description)
        )

        val adeptusMechanicus = Background(
            Backgrounds.ADEPTUS_MECHANICUS,
            arrayOf(Pair(Skills.AWARENESS, Skills.OPERATE)),
            arrayOf(Skills.CL_ADEPTUS_MECHANICUS, Skills.LOGIC, Skills.SECURITY, Skills.TECH_USE),
            arrayOf(Talents.MU_UTILITY, Talents.WT_SOLID_PROJECTILE),
            arrayOf(),
            Bonus(
                R.string.replace_the_weak_flesh_title,
                R.string.replace_the_weak_flesh_description
            ),
            arrayOf(Aptitudes.KNOWLEDGE, Aptitudes.TECH),
            Bonus(R.string.mechanicus_implants_title, R.string.mechanicus_implants_description)
        )

        val adeptusMinistorum = Background(
            Backgrounds.ADEPTUS_MINISTORUM,
            arrayOf(Pair(Skills.INQUIRY, Skills.SCRUTINY)),
            arrayOf(
                Skills.CHARM,
                Skills.COMMAND,
                Skills.CL_ADEPTUS_MINISTORUM,
                Skills.LINGUISTICS_HIGH_GOTHIC
            ),
            arrayOf(),
            arrayOf(
                Pair(Talents.WT_FLAME, Talents.WT_SOLID_PROJECTILE),
                Pair(Talents.WT_FLAME, Talents.LOW_TECH)
            ),
            Bonus(R.string.faith_is_all_title, R.string.faith_is_all_description),
            arrayOf(Aptitudes.LEADERSHIP, Aptitudes.SOCIAL)
        )

        val imperialGuard = Background(
            Backgrounds.IMPERIAL_GUARD,
            arrayOf(Pair(Skills.MEDICAE, Skills.O_SURFACE)),
            arrayOf(Skills.ATHLETICS, Skills.COMMAND, Skills.CL_IMPERIAL_GUARD, Skills.N_SURFACE),
            arrayOf(Talents.WT_LAS, Talents.LOW_TECH),
            arrayOf(),
            Bonus(R.string.hammer_of_the_emperor_title, R.string.hammer_of_the_emperor_description),
            arrayOf(Aptitudes.FIELDCRAFT, Aptitudes.LEADERSHIP)
        )

        val outcast = Background(
            Backgrounds.OUTCAST,
            arrayOf(Pair(Skills.ACROBATICS, Skills.SLEIGHT_OF_HAND)),
            arrayOf(Skills.CL_UNDERWORLD, Skills.DECEIVE, Skills.DODGE, Skills.STEALTH),
            arrayOf(Talents.WT_CHAIN),
            arrayOf(Pair(Talents.WT_SOLID_PROJECTILE, Talents.WT_LAS)),
            Bonus(R.string.never_quit_title, R.string.never_quit_description),
            arrayOf(Aptitudes.SOCIAL, Aptitudes.FIELDCRAFT)
        )

        val backgrounds = arrayOf(
            adeptusAdministratum,
            adeptusArbites,
            adeptusAstraTelepathica,
            adeptusMechanicus,
            adeptusMinistorum,
            imperialGuard,
            outcast
        )
    }
}