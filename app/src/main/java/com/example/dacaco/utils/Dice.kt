package com.example.dacaco.utils

class Dice(val dices: Int, val diceSides: Int, val modifier: Int = 0, val sumIt: Boolean = false) {

    fun throwIt(): MutableList<Int> {
        return if (sumIt) throwIdNAndSum(dices, diceSides, modifier) else throwIdN(
            dices,
            diceSides,
            modifier
        )
    }


    companion object {
        fun throw1dN(diceSides: Int, modifier: Int = 0): Int = (1..diceSides).random() + modifier
        fun throwIdN(dices: Int, diceSides: Int, modifier: Int = 0): MutableList<Int> {
            val list: MutableList<Int> = arrayListOf()
            for (j in 1..dices) {
                list.add((0..diceSides).random() + modifier)
            }
            return list
        }

        fun throwIdNAndSum(dices: Int, diceSides: Int, modifier: Int = 0): MutableList<Int> {
            val list: MutableList<Int> = arrayListOf(modifier)
            for (j in 1..dices) {
                list[0] += (0..diceSides).random()
            }
            return list
        }
    }
}