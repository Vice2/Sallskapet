package se.jessikagerhardsson.sallskapet

import kotlin.random.Random

class HangmanGameManager {
    private var lettersUsed: String = ""
    private lateinit var underscoreWord: String
    private lateinit var wordToGuess: String
    private val maxTries = 8
    private var currentTries = 0
    private var drawable: Int = R.drawable.pic1

    fun startNewGame(): HangmanGameState {
        lettersUsed = ""
        currentTries = 0
        drawable = R.drawable.pic8
        val randomIndex = Random.nextInt(0, HangmanGameConstants.words.size)
        wordToGuess = HangmanGameConstants.words[randomIndex]
        generateUnderscores(wordToGuess)
        return getGameState()
    }

    fun generateUnderscores(word: String) {
        val sb = StringBuilder()
        word.forEach { char ->
            if (char == '/') {
                sb.append('/')
            } else {
                sb.append("_")
            }
        }
        underscoreWord = sb.toString()
    }

    fun play(letter: Char): HangmanGameState {
        if (lettersUsed.contains(letter)) {
            return HangmanGameState.Running(lettersUsed, underscoreWord, drawable)
        }

        lettersUsed += letter
        val indexes = mutableListOf<Int>()

        wordToGuess.forEachIndexed { index, char ->
            if (char.equals(letter, true)) {
                indexes.add(index)
            }
        }

        var finalUnderscoreWord = "" + underscoreWord // _ _ _ _ _ _ _ -> E _ _ _ _ _ _
        indexes.forEach { index ->
            val sb = StringBuilder(finalUnderscoreWord).also { it.setCharAt(index, letter) }
            finalUnderscoreWord = sb.toString()
        }

        if (indexes.isEmpty()) {
            currentTries++
        }

        underscoreWord = finalUnderscoreWord
        return getGameState()
    }

    private fun getHangmanDrawable(): Int {
        return when (currentTries) {
            0 -> R.drawable.pic1
            1 -> R.drawable.pic1
            2 -> R.drawable.pic2
            3 -> R.drawable.pic3
            4 -> R.drawable.pic4
            5 -> R.drawable.pic5
            6 -> R.drawable.pic6
            7 -> R.drawable.pic7
            8 -> R.drawable.pic8
            else -> R.drawable.pic8
        }
    }

    private fun getGameState(): HangmanGameState {
        if (underscoreWord.equals(wordToGuess, true)) {
            return HangmanGameState.Won(wordToGuess)
        }

        if (currentTries == maxTries) {
            return HangmanGameState.Lost(wordToGuess)
        }

        drawable = getHangmanDrawable()
        return HangmanGameState.Running(lettersUsed, underscoreWord, drawable)
    }
}