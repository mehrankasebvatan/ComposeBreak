package ir.kasebvatan.countdown.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.kasebvatan.designsystem.theme.ComposeBreakTheme
import ir.kasebvatan.designsystem.theme.ThemePreviews

@Composable
fun Counter(
    minutes: String, seconds: String
) {

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
                minutes = "19", seconds = "39"
            )
        }
    }
}