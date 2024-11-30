package ir.kasebvatan.composebreak

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.kasebvatan.countdown.CountdownScreen
import ir.kasebvatan.designsystem.theme.ComposeBreakTheme
import ir.kasebvatan.designsystem.theme.ThemePreviews

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBreakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    CountdownScreen()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ThemePreviews
@Composable
fun GreetingPreview() {
    ComposeBreakTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            CountdownScreen()
        }

    }
}