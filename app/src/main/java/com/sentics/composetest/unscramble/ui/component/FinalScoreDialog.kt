package com.sentics.composetest.unscramble.ui.component

import android.app.Activity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sentics.composetest.R
import com.sentics.composetest.unscramble.ui.theme.UnscrambleTheme

@Composable
fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(
        modifier = modifier,
        title = { Text(text = stringResource(id = R.string.unscramble_congratulations)) },
        text = { Text(text = stringResource(id = R.string.unscramble_you_scored, score)) },
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(text = stringResource(id = R.string.unscramble_play_again))
            }
        },
        dismissButton = {
            TextButton(onClick = { activity.finish() }) {
                Text(text = stringResource(id = R.string.unscramble_exit))
            }
        },
        onDismissRequest = { },
    )
}

@Preview
@Composable
private fun FinalScoreDialogPreview() {
    UnscrambleTheme {
        FinalScoreDialog(score = 23, onPlayAgain = { /*TODO*/ })
    }
}