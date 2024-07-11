package com.sentics.composetest.unscramble.ui.state

data class UnscrambleUiState(
    val currentScrambledWord: String = "",
    val isGuessWrong: Boolean = false,
    val wordCount: Int = 1,
    val score: Int = 0
) {
    companion object {
        private const val WORDS_PER_GAME = 10
    }

    val maxWordCount get() = WORDS_PER_GAME
    val isGameOver get() = wordCount == maxWordCount
}
