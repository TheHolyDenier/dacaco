package com.example.dacaco.utils

import com.example.dacaco.R

enum class Skills(
    val id: Int,
    val aptitude1: Aptitudes,
    val aptitude2: Aptitudes,
    val focuseable: Boolean = false,
    val parent: Skills? = null
) {
    ACROBATICS(R.string.acrobatics, Aptitudes.AGILITY, Aptitudes.GENERAL),
    ATHLETICS(R.string.athletics, Aptitudes.STRENGTH, Aptitudes.GENERAL),
    AWARENESS(R.string.awareness, Aptitudes.PERCEPTION, Aptitudes.FIELDCRAFT),
    CHARM(R.string.charm, Aptitudes.FELLOWSHIP, Aptitudes.SOCIAL),
    COMMAND(R.string.command, Aptitudes.FELLOWSHIP, Aptitudes.LEADERSHIP),
    COMMERCE(R.string.commerce, Aptitudes.INTELLIGENCE, Aptitudes.KNOWLEDGE),
    COMMON_LORE(R.string.common_lore, Aptitudes.INTELLIGENCE, Aptitudes.GENERAL, true),
    CL_ADEPTUS_ADMINISRATUM(
        R.string.adeptus_administratum,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        COMMON_LORE
    ),
    CL_ADEPTUS_ARBITES(
        R.string.adeptus_arbites,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        COMMON_LORE
    ),
    CL_UNDERWORLD(
        R.string.cl_underworld,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        COMMON_LORE
    ),
    CL_ADEPTUS_ASTRA_TELEPATHICA(
        R.string.adeptus_astra_telephatica,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        COMMON_LORE
    ),
    CL_ADEPTUS_MECHANICUS(
        R.string.adeptus_mechanicus,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        COMMON_LORE
    ),
    CL_ADEPTUS_MINISTORUM(
        R.string.adeptus_ministorum,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        COMMON_LORE
    ),
    CL_IMPERIAL_GUARD(
        R.string.imperial_guard,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        COMMON_LORE
    ),
    DECEIVE(R.string.deceive, Aptitudes.FELLOWSHIP, Aptitudes.SOCIAL),
    DODGE(R.string.dodge, Aptitudes.AGILITY, Aptitudes.DEFENCE),
    FORBIDDEN_LORE(R.string.forbidden_lore, Aptitudes.INTELLIGENCE, Aptitudes.KNOWLEDGE, true),
    FL_WARP(R.string.fl_warp, Aptitudes.INTELLIGENCE, Aptitudes.KNOWLEDGE, false, FORBIDDEN_LORE),
    INQUIRY(R.string.inquiry, Aptitudes.FELLOWSHIP, Aptitudes.SOCIAL),
    INTERROGATION(R.string.interrogation, Aptitudes.WILLPOWER, Aptitudes.SOCIAL),
    INTIMIDATE(R.string.intimidate, Aptitudes.STRENGTH, Aptitudes.SOCIAL),
    LINGUISTICS(R.string.linguistics, Aptitudes.INTELLIGENCE, Aptitudes.GENERAL, true),
    LINGUISTICS_HIGH_GOTHIC(
        R.string.linguistics_high_gothic,
        Aptitudes.INTELLIGENCE,
        Aptitudes.GENERAL,
        false,
        LINGUISTICS
    ),
    LOGIC(R.string.logic, Aptitudes.INTELLIGENCE, Aptitudes.KNOWLEDGE),
    MEDICAE(R.string.medicae, Aptitudes.INTELLIGENCE, Aptitudes.FIELDCRAFT),
    NAVIGATE(R.string.navigate, Aptitudes.INTELLIGENCE, Aptitudes.FIELDCRAFT, true),
    N_SURFACE(R.string.surface, Aptitudes.INTELLIGENCE, Aptitudes.FIELDCRAFT, false, NAVIGATE),
    OPERATE(R.string.operate, Aptitudes.AGILITY, Aptitudes.FIELDCRAFT, true),
    O_SURFACE(R.string.surface, Aptitudes.AGILITY, Aptitudes.FIELDCRAFT, false, OPERATE),
    PARRY(R.string.parry, Aptitudes.WEAPON_SKILL, Aptitudes.DEFENCE),
    PSYNISCIENCE(R.string.psyniscience, Aptitudes.PERCEPTION, Aptitudes.PSYKER),
    SCHOLASTIC_LORE(R.string.scholastic_lore, Aptitudes.INTELLIGENCE, Aptitudes.KNOWLEDGE),
    SCRUTINY(R.string.scrutiny, Aptitudes.PERCEPTION, Aptitudes.GENERAL),
    SECURITY(R.string.security, Aptitudes.INTELLIGENCE, Aptitudes.TECH),
    SLEIGHT_OF_HAND(R.string.sleight_of_hand, Aptitudes.AGILITY, Aptitudes.KNOWLEDGE),
    STEALTH(R.string.stealth, Aptitudes.AGILITY, Aptitudes.FIELDCRAFT),
    SURVIVAL(R.string.survival, Aptitudes.PERCEPTION, Aptitudes.FIELDCRAFT),
    TECH_USE(R.string.tech_use, Aptitudes.INTELLIGENCE, Aptitudes.TECH),
    TRADE(R.string.trade, Aptitudes.INTELLIGENCE, Aptitudes.GENERAL)


}