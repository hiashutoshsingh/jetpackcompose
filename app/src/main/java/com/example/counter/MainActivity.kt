package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Button as Button1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{Counter()}
    }

    @Composable
    fun Counter(){
        val count  = remember {
            mutableStateOf(0)
        }

        Button1(onClick = { count.value++ }) { Text("Clicked ${count.value.toString()} times!")
        }

    }

    @Preview
    @Composable
    fun MainUI(){
        Counter()
    }
}