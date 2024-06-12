package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5.ui.theme.Lab5Theme

/*
Створити проект застосунку з простим функціоналом та
ViewBinding.
 Додати обробку кліку елемента та будь-яку дію по кліку, яку видно
при роботі застосунку
 Додати різну обробку кліку для декількох кнопок або декількох
візульних елементів
 Додати обробку будь-якої іншої події (не кліку) для будь-якого
візуального елемента
 Додати обробку зміну тексту (before,after, onTextChanged)
 Винести обробку подій в інший, окремий клаc
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(text = "Activity1")
                        var textValue by remember {
                            mutableStateOf("")
                        }
                        Row(modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly) {
                            TextField(
                                modifier = Modifier.weight(2f),value = textValue, onValueChange = { newString ->
                                textValue = newString
                            })
                            Button(
                                modifier = Modifier.weight(1f).wrapContentSize(),
                                onClick = { textValue = "" }) {
                                Text(text = "Clear")
                            }
                        }

                        Button(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .wrapContentSize(),
                            onClick = {
                                Toast.makeText(this@MainActivity, "Hello!", Toast.LENGTH_LONG)
                                    .show()
                            }) {
                            Text(text = "Show Toast")
                        }
                        Button(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .wrapContentSize(),
                            onClick = {
                                startActivity(
                                    Intent(this@MainActivity, MainActivity2::class.java)
                                )
                            }) {
                            Text(text = "Open second activity")
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
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5Theme {
        Greeting("Android")
    }
}