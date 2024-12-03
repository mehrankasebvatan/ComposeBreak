package ir.kasebvatan.countdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.kasebvatan.countdown.component.Counter
import ir.kasebvatan.countdown.component.CounterController
import ir.kasebvatan.countdown.model.CountdownState
import ir.kasebvatan.designsystem.theme.ComposeBreakTheme
import ir.kasebvatan.designsystem.theme.ThemePreviews

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel
) {

    val state = viewModel.countdownState.collectAsState().value
    CountdownScreen(
        countdownState = state,
        onResetClicked = { viewModel.resetCountdown() },
        onStartClicked = { viewModel.startCountdown() })

}


@Composable
fun CountdownScreen(
    countdownState: CountdownState,
    onResetClicked: () -> Unit,
    onStartClicked: () -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Counter(countdownState = countdownState)

        Spacer(modifier = Modifier.height(16.dp))

        CounterController(counterState = countdownState.counterState,
            onResetClicked = { onResetClicked() },
            onStartClicked = { onStartClicked() })
    }

}


@ThemePreviews
@Composable
private fun CountdownScreenPreview() {

    ComposeBreakTheme {
        Surface {
            CountdownScreen(
                countdownState = CountdownState(),
                onResetClicked = { },
                onStartClicked = {})
        }
    }

}