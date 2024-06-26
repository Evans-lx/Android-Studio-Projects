package com.example.buttonlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.buttonlab.ui.theme.ButtonLabTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomNumberGenerator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RandomNumberGenerator(modifier: Modifier = Modifier) {
    var max by remember { mutableStateOf(10) }
    var result by remember { mutableStateOf(1) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = max.toString(),
            onValueChange = { newMax:String -> max = newMax.toIntOrNull()
                ?:1 },
            label = { Text("Max") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType =
            KeyboardType.Number),
            //TextField to have max width, with some space from the button
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Button(
            onClick = {
                //To include the last value (max) = (max + 1)
                result = Random.nextInt(1, max + 1)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Random Number")
        }
        Text("Result: $result", style =
        MaterialTheme.typography.labelMedium)
    }
}
