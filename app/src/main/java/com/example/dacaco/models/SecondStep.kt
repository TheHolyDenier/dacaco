package com.example.dacaco.models

import com.example.dacaco.utils.Aptitudes
import com.example.dacaco.utils.Skills
import com.example.dacaco.utils.Talents


/**
 *** Created by Helena Juliá (hjulias@gmail.com) on 07/08/2020.
 **/

class SecondStep {
    var background: String = ""
    var skills: ArrayList<Skills> = arrayListOf()
    var talents: ArrayList<Talents> = arrayListOf()
    var bonus: ArrayList<Bonus> = arrayListOf()
    var aptitudes: ArrayList<Aptitudes> = arrayListOf()
}