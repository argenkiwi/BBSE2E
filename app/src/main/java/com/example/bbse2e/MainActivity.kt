package com.example.bbse2e

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbse2e.ui.theme.BBSE2ETheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BBSE2ETheme {
                val state = rememberBottomSheetScaffoldState()
                BottomSheetScaffold(
                    sheetContent = { Greeting(name = "Android") },
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = state,
                    sheetPeekHeight = 128.dp
                ) { paddingValues ->
                    var showModal by remember { mutableStateOf(false) }
                    if (showModal) {
                        ModalBottomSheet({ showModal = false }) {
                            Greeting(name = "Android")
                        }
                    }

                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        contentAlignment = Alignment.Center
                    ) {
                        TextButton({ showModal = true }) {
                            Text("Show Modal Bottom Sheet")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = buildString {
            appendLine("Hello $name!")
            appendLine("Hello $name!")
            appendLine("Hello $name!")
            appendLine("Hello $name!")
            appendLine("Hello $name!")
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BBSE2ETheme {
        Greeting("Android")
    }
}