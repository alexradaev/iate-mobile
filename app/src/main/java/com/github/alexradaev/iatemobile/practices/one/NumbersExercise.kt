package com.github.alexradaev.iatemobile.practices.one

import kotlin.random.Random

/**
 * In list of N elements, select all elements are twice the Z. Create a list from the indexes of these elements and print them.
 */
class NumbersExercise {
    var number: Int =0
    var numbers: List<Int> = listOf()

    init {
        updateNumbers()
    }

    fun updateNumbers(){
        numbers = List(10){ Random.nextInt(1, 10) }
    }

    fun listOfIndexes(): List<Int>{
        return numbers
            .withIndex()
            .filter{ (index, value) -> value == 2*number }
            .map{ (index, value) -> index }
    }
}