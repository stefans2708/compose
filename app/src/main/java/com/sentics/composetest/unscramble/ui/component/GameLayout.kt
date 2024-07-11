package com.sentics.composetest.unscramble.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.unscramble.ui.theme.UnscrambleTheme

@Composable
fun GameLayout(
    scrambledWord: String,
    userGuess: String,
    wordCount: Int,
    maxWordCount: Int,
    isGuessWrong: Boolean,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Text(
            text = stringResource(id = R.string.unscramble_word_count, wordCount, maxWordCount),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(mediumPadding)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(vertical = 2.dp, horizontal = 8.dp)
                .align(Alignment.End)
        )
        Text(
            text = scrambledWord,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = mediumPadding),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(id = R.string.unscramble_instructions),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(mediumPadding)
                .align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = userGuess,
            onValueChange = onUserGuessChanged,
            shape = MaterialTheme.shapes.large,
            isError = isGuessWrong,
            colors = TextFieldDefaults.colors(unfocusedContainerColor = MaterialTheme.colorScheme.surface),
            singleLine = true,
            label = {
                if (isGuessWrong) {
                    Text(stringResource(R.string.unscramble_wrong_guess))
                } else {
                    Text(stringResource(R.string.unscramble_enter_your_word))
                }
            },
            modifier = Modifier
                .padding(mediumPadding)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { onKeyboardDone() })
        )
    }
}

@Preview
@Composable
private fun GameLayoutPreview() {
    UnscrambleTheme {
        GameLayout(
            scrambledWord = "scrambleun",
            userGuess = "",
            wordCount = 2,
            maxWordCount = 12,
            isGuessWrong = true,
            onUserGuessChanged = {},
            onKeyboardDone = { },
        )
    }
}
