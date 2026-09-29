package com.example.turnstile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.turnstile.ui.theme.TurnstileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TurnstileTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TurnstileScreen()
                }
            }
        }
    }
}

@Composable
fun TurnstileScreen() {
    val gate = remember { TurnstileGate() }

    var ticketType by remember { mutableStateOf("PATRON") }
    var heightInput by remember { mutableStateOf("") }
    var ageInput by remember { mutableStateOf("") }
    var hasGuardian by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("Waiting for rider...") }
    var granted by remember { mutableStateOf(0) }
    var denied by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Apex Vortex Turnstile", style = MaterialTheme.typography.headlineSmall)

        // Ticket type picker (same RadioButton pattern as the Cupcake codelab)
        listOf("PATRON", "VIP", "UNAUTHORIZED").forEach { type ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = ticketType == type,
                    onClick = { ticketType = type }
                )
                Text(type)
            }
        }

        TextField(
            value = heightInput,
            onValueChange = { heightInput = it },
            label = { Text("Height (inches)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // TODO (SE Story 2): copy the Height TextField above and change it into an Age field
        //                   (value = ageInput, onValueChange = { ageInput = it }, label "Age")

        // TODO (SE Story 2): a Row with Text("Guardian present") and a Switch bound to hasGuardian
        //                   (same pattern as the "Round up tip?" Switch in Tip Time)

        // TODO (SE Story 2): a Button labelled "SCAN RIDER" whose onClick:
        //   1. turns heightInput into a Double with .toDoubleOrNull() ?: -1.0
        //   2. turns ageInput into an Int with .toIntOrNull() ?: -1
        //      (-1 is impossible, so the rules answer DENIED_INVALID - no crash on blank input)
        //   3. result = gate.scan(ticketType, height, age, hasGuardian)
        //   4. granted = gate.grantedCount  and  denied = gate.deniedCount

        Text(result, style = MaterialTheme.typography.titleLarge)
        Text("Granted: $granted   Denied: $denied   Total: ${granted + denied}")
    }
}

@Preview(showBackground = true)
@Composable
fun TurnstileScreenPreview() {
    TurnstileTheme {
        TurnstileScreen()
    }
}
