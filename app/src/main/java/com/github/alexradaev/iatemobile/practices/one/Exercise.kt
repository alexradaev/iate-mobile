package com.github.alexradaev.iatemobile.practices.one

abstract class Exercise {
    var number: Int = 0
    abstract var inputData: String
    abstract var result: Map<String, String>
}