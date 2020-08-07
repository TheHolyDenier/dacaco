package com.example.dacaco.models

import com.example.dacaco.R
import com.example.dacaco.utils.Aptitudes
import com.example.dacaco.utils.Backgrounds
import com.example.dacaco.utils.Skills
import com.example.dacaco.utils.Talents

class Background(
    val title: Backgrounds,
    val betweenSkills: ArrayList<Pair<Skills, Skills>>,
    val skills: ArrayList<Skills>,
    val talents: ArrayList<Talents>,
    val betweenTalents: ArrayList<Pair<Talents, Talents>>,
    val bonus: Bonus,
    val aptitudes: ArrayList<Aptitudes>,
    val other: Bonus? = null
) {
    companion object {
        val adeptusAdministratum = Background(
            Backgrounds.ADEPTUS_ADMINISTRATUM,
            arrayListOf(Pair(Skills.COMMERCE, Skills.MEDICAE)),
            arrayListOf(
                Skills.LINGUISTICS,
                Skills.LOGIC,
                Skills.SCHOLASTIC_LORE,
                Skills.CL_ADEPTUS_ADMINISRATUM
            ),
            arrayListOf(),
            arrayListOf(
                Pair(
                    Talents.WT_LAS,
                    Talents.WT_SOLID_PROJECTILE
                )
            ),
            Bonus(R.string.master_of_paperwork_title, R.string.master_of_paperwork_description),
            arrayListOf(
                Aptitudes.KNOWLEDGE, Aptitudes.SOCIAL
            )
        )
        val adeptusArbites = Background(
            Backgrounds.ADEPTUS_ARBITES,
            arrayListOf(Pair(Skills.INQUIRY, Skills.INTERROGATION)),
            arrayListOf(
                Skills.SCRUTINY,
                Skills.INTIMIDATE,
                Skills.AWARENESS,
                Skills.CL_ADEPTUS_ARBITES,
                Skills.CL_UNDERWORLD
            ),
            arrayListOf(),
            arrayListOf(Pair(Talents.WT_SOLID_PROJECTILE, Talents.WT_SHOCK)),
            Bonus(R.string.the_face_of_the_law_title, R.string.the_face_of_the_law_description),
            arrayListOf(Aptitudes.OFFENCE, Aptitudes.DEFENCE)
        )

        val adeptusAstraTelepathica = Background(
            Backgrounds.ADEPTUS_ASTRA_TELEPATHICA,
            arrayListOf(
                Pair(Skills.DECEIVE, Skills.INTERROGATION),
                Pair(Skills.PSYNISCIENCE, Skills.SCRUTINY)
            ),
            arrayListOf(Skills.AWARENESS, Skills.CL_ADEPTUS_ASTRA_TELEPATHICA, Skills.FL_WARP),
            arrayListOf(),
            arrayListOf(Pair(Talents.WT_LAS, Talents.LOW_TECH)),
            Bonus(R.string.constant_thread_title, R.string.constant_thread_description),
            arrayListOf(Aptitudes.DEFENCE, Aptitudes.PSYKER),
            Bonus(R.string.tested_on_terra_title, R.string.tested_on_terra_description)
        )

        val adeptusMechanicus = Background(
            Backgrounds.ADEPTUS_MECHANICUS,
            arrayListOf(Pair(Skills.AWARENESS, Skills.OPERATE)),
            arrayListOf(Skills.CL_ADEPTUS_MECHANICUS, Skills.LOGIC, Skills.SECURITY, Skills.TECH_USE),
            arrayListOf(Talents.MU_UTILITY, Talents.WT_SOLID_PROJECTILE),
            arrayListOf(),
            Bonus(
                R.string.replace_the_weak_flesh_title,
                R.string.replace_the_weak_flesh_description
            ),
            arrayListOf(Aptitudes.KNOWLEDGE, Aptitudes.TECH),
            Bonus(R.string.mechanicus_implants_title, R.string.mechanicus_implants_description)
        )

        val adeptusMinistorum = Background(
            Backgrounds.ADEPTUS_MINISTORUM,
            arrayListOf(Pair(Skills.INQUIRY, Skills.SCRUTINY)),
            arrayListOf(
                Skills.CHARM,
                Skills.COMMAND,
                Skills.CL_ADEPTUS_MINISTORUM,
                Skills.LINGUISTICS_HIGH_GOTHIC
            ),
            arrayListOf(),
            arrayListOf(
                Pair(Talents.WT_FLAME, Talents.WT_SOLID_PROJECTILE),
                Pair(Talents.WT_FLAME, Talents.LOW_TECH)
            ),
            Bonus(R.string.faith_is_all_title, R.string.faith_is_all_description),
            arrayListOf(Aptitudes.LEADERSHIP, Aptitudes.SOCIAL)
        )

        val imperialGuard = Background(
            Backgrounds.IMPERIAL_GUARD,
            arrayListOf(Pair(Skills.MEDICAE, Skills.O_SURFACE)),
            arrayListOf(Skills.ATHLETICS, Skills.COMMAND, Skills.CL_IMPERIAL_GUARD, Skills.N_SURFACE),
            arrayListOf(Talents.WT_LAS, Talents.LOW_TECH),
            arrayListOf(),
            Bonus(R.string.hammer_of_the_emperor_title, R.string.hammer_of_the_emperor_description),
            arrayListOf(Aptitudes.FIELDCRAFT, Aptitudes.LEADERSHIP)
        )

        val outcast = Background(
            Backgrounds.OUTCAST,
            arrayListOf(Pair(Skills.ACROBATICS, Skills.SLEIGHT_OF_HAND)),
            arrayListOf(Skills.CL_UNDERWORLD, Skills.DECEIVE, Skills.DODGE, Skills.STEALTH),
            arrayListOf(Talents.WT_CHAIN),
            arrayListOf(Pair(Talents.WT_SOLID_PROJECTILE, Talents.WT_LAS)),
            Bonus(R.string.never_quit_title, R.string.never_quit_description),
            arrayListOf(Aptitudes.SOCIAL, Aptitudes.FIELDCRAFT)
        )

        val backgrounds = arrayListOf(
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