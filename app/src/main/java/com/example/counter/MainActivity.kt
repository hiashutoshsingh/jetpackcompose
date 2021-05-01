package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.Button as Button1
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Content() }
    }

    @Composable
    fun Content() {

        /// managing state using remember
        /// state is managed, but not when configuration changes
        //        val count = remember {
        //            mutableStateOf(0)
        //        }

        /// managing state using rememberSaveable
        /// state is managed even if configuration changes
        var count by rememberSaveable { mutableStateOf(0) }
        Counter(count, onValueChange = {  count })
    }

    @Composable
    fun Counter(count: Int, onValueChange: (Int) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button1(onClick = { onValueChange(count+1) } ) {
                Text("Clicked $count times!")
            }
        }

    }

}

