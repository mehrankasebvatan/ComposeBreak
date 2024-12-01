package ir.kasebvatan.countdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.kasebvatan.countdown.component.Counter
import ir.kasebvatan.countdown.component.CounterController
import ir.kasebvatan.countdown.model.CountdownState
import ir.kasebvatan.countdown.model.CounterState
import ir.kasebvatan.designsystem.theme.ComposeBreakTheme
import ir.kasebvatan.designsystem.theme.ThemePreviews

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel
) {

}


@Composable
fun CountdownScreen(
    counterState: CounterState,
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

        CounterController(counterState = counterState,
            onResetClicked = { onResetClicked() },
            onStartClicked = { onStartClicked() })
    }

}


@ThemePreviews
@Composable
private fun CountdownScreenPreview() {

    ComposeBreakTheme {
        Surface {
            CountdownScreen(counterState = CounterState.INITIAL,
                countdownState = CountdownState(),
                onResetClicked = { },
                onStartClicked = {})
        }
    }

}