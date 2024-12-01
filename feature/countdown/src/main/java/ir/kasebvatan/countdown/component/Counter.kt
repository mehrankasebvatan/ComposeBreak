package ir.kasebvatan.countdown.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.kasebvatan.countdown.CountdownState
import ir.kasebvatan.designsystem.theme.ComposeBreakTheme
import ir.kasebvatan.designsystem.theme.ThemePreviews
import ir.kasebvatan.ext_functions.minutes
import ir.kasebvatan.ext_functions.seconds

@Composable
fun Counter(countdownState: CountdownState) {

    val minutes by remember {
        mutableStateOf(countdownState.remainTime.minutes.toString())
    }

    val seconds by remember {
        mutableStateOf(countdownState.remainTime.seconds.toString())
    }

    Row(
        modifier = Modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        CounterText(text = minutes)
        Text(text = " : ")
        CounterText(text = seconds)
    }

}


@ThemePreviews
@Composable
private fun CounterPreview() {
    ComposeBreakTheme {
        Surface {
            Counter(
                countdownState = CountdownState()
            )
        }
    }
}