package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.ui.theme.JetpackTheme
import androidx.compose.runtime.remember as remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                var name by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                 Column (
                     modifier = Modifier
                         .fillMaxSize()
                         .padding(
                             vertical = 48.dp,
                             horizontal = 16.dp
                         )
                         ,
                 ) {
                     Row (
                         modifier = Modifier.fillMaxWidth()
                     ){
                         OutlinedTextField(
                             modifier = Modifier.weight(1f),
                             value = name,
                             onValueChange = { text ->
                                 name = text
                             }

                         )
                         Spacer(modifier = Modifier.width(16.dp))
                         Button(onClick = {
                             if (name.isNotBlank()) {
                                 names = names + name

                             }

                         }) {
                             Text(text = "Add")
                         }
                     }
                     LazyColumn {
                         items(names) { currentName ->
                             Text(
                                 text = currentName,
                                 modifier = Modifier
                                     .fillMaxWidth()
                                     .padding(16.dp)
                             )
                             Divider()
                         }
                     }
                 }

            }
        }
    }
}



