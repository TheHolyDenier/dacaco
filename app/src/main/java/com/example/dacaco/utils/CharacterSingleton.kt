package com.example.dacaco.utils

import com.example.dacaco.models.Character

class CharacterSingleton {
    companion object {
        var character: Character? = null
    }
}