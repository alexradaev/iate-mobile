package com.github.alexradaev.iatemobile.practices.one

/**
 * Count statistics for the given text: number of sentences, number of words, average length of the word.
 */
class StringsExercise {
    val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris faucibus porttitor tincidunt. Sed orci libero, efficitur id eleifend sit amet, hendrerit quis nibh. Cras et commodo lectus. Maecenas sem libero, condimentum semper condimentum non, mollis viverra massa. Donec cursus maximus gravida. Pellentesque vitae cursus magna, at egestas nulla. Ut eget augue eget magna mattis convallis a sed nisl. Donec ut porta lorem, et dapibus dolor. Pellentesque ac erat tortor. Donec a est at ante bibendum aliquam eu non enim. Suspendisse ut purus ut lacus tincidunt pretium. Etiam ultrices elit risus, sit amet sagittis felis tempus quis. In at est accumsan, malesuada metus vel, cursus lacus. Etiam ac sodales felis."

    val numOfSentences = text.split(".").filter{ !it.isEmpty() }.map{ it.trim() }.count()
    val words = text.split(" ").filter{ it.all { it.isLetter() } }
    val numOfWords = words.count()
    val averageWordLength = words.map{ it.length }.average()
}