package ir.kasebvatan.countdown.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.kasebvatan.countdown.CounterState
import ir.kasebvatan.designsystem.theme.ComposeBreakTheme
import ir.kasebvatan.designsystem.theme.ThemePreviews

@Composable
fun CounterController(
    counterState: CounterState,
    onResetClicked: () -> Unit,
    onStartClicked: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {

    }
    Button(
        modifier = Modifier.fillMaxWidth(fraction = 0.3f),
        onClick = {
            when (counterState) {
                CounterState.INITIAL -> onStartClicked()
                CounterState.PLAY -> onResetClicked()
                CounterState.PAUSE -> onResetClicked()
            }
        }) {
        Icon(
            imageVector =
            when (counterState) {
                CounterState.INITIAL -> Icons.Default.PlayArrow
                CounterState.PLAY -> Icons.Filled.Close
                CounterState.PAUSE -> Icons.Default.PlayArrow
            }, contentDescription = ""
        )
    }
}


@ThemePreviews
@Composable
private fun CounterControllerPreview() {
    ComposeBreakTheme {
        Surface {
            CounterController(
                CounterState.INITIAL,
                onResetClicked = {},
                onStartClicked = {})
        }
    }
}