package com.sentics.composetest.unscramble.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sentics.composetest.unscramble.data.WordsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UnscrambleViewModel : ViewModel() {

    private var currentWord = ""
    private val usedWords = mutableListOf<String>()
    private val _uiState = MutableStateFlow(UnscrambleUiState())

    val uiState: StateFlow<UnscrambleUiState> = _uiState
    var userGuess by mutableStateOf(""); private set

    init {
        resetGame()
    }

    fun resetGame() {
        updateUserGuess("")
        usedWords.clear()
        _uiState.value = UnscrambleUiState(getNextWord())
    }

    fun checkSolution() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            updateUserGuess("")
            _uiState.update { currentState ->
                currentState.copy(
                    currentScrambledWord = getNextWord(),
                    score = _uiState.value.score + 1,
                    isGuessWrong = false,
                    wordCount = _uiState.value.wordCount + 1,
                )
            }
        } else {
            _uiState.update { it.copy(isGuessWrong = true) }
        }
    }

    fun skipWord() {
        updateUserGuess("")
        _uiState.update { currentState ->
            currentState.copy(
                currentScrambledWord = getNextWord(),
                wordCount = _uiState.value.wordCount + 1,
            )
        }
    }

    fun updateUserGuess(guess: String) {
        userGuess = guess
    }

    private fun getNextWord(): String {
        currentWord = WordsData.allWords.random()
        while (usedWords.contains(currentWord)) {
            currentWord = WordsData.allWords.random()
        }

        usedWords.add(currentWord)

        return shuffleWord(currentWord)
    }

    private fun shuffleWord(word: String): String {
        val shuffledCharArray = word.toCharArray().apply { shuffle() }

        while (String(shuffledCharArray) == word) {
            shuffledCharArray.shuffle()
        }

        return String(shuffledCharArray)
    }
}
