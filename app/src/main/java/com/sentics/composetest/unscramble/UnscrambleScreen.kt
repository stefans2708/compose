package com.sentics.composetest.unscramble

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sentics.composetest.R
import com.sentics.composetest.unscramble.ui.component.FinalScoreDialog
import com.sentics.composetest.unscramble.ui.component.GameLayout
import com.sentics.composetest.unscramble.ui.component.GameStatus
import com.sentics.composetest.unscramble.ui.state.UnscrambleViewModel
import com.sentics.composetest.unscramble.ui.theme.UnscrambleTheme

@Composable
fun UnscrambleScreen(
    modifier: Modifier = Modifier,
    vm: UnscrambleViewModel = viewModel()
) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val uiState by vm.uiState.collectAsStateWithLifecycle()

    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(mediumPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.unscramble_game_name),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(mediumPadding)
            )

            GameLayout(
                scrambledWord = uiState.currentScrambledWord,
                wordCount = uiState.wordCount,
                maxWordCount = uiState.maxWordCount,
                userGuess = vm.userGuess,
                isGuessWrong = uiState.isGuessWrong,
                onUserGuessChanged = { vm.updateUserGuess(it) },
                onKeyboardDone = { vm.checkSolution() },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = mediumPadding),
                onClick = { vm.checkSolution() }
            ) {
                Text(text = stringResource(id = R.string.unscramble_submit))
            }
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                onClick = { vm.skipWord() }
            ) {
                Text(text = stringResource(id = R.string.unscramble_skip))
            }

            GameStatus(score = uiState.score, modifier = Modifier.padding(mediumPadding))
        }

        if (uiState.isGameOver) {
            FinalScoreDialog(
                score = uiState.score,
                onPlayAgain = { vm.resetGame() }
            )
        }
    }
}

@Preview
@Composable
private fun UnscrambleScreenPreview() {
    UnscrambleTheme {
        UnscrambleScreen()
    }
}
