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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.Button as Button1

import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Content() }
    }


    @Composable
    fun Content(countViewModel: CountViewModel = viewModel()) {

        val count: Int by countViewModel.count.observeAsState(0)
        Counter(count = count, onCountChange = { countViewModel.countChange(count + 1) })
    }

    @Composable
    fun Counter(count: Int, onCountChange: (Int) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button1(onClick = { onCountChange(count) }) {
                Text("Clicked $count times!")
            }
        }

    }

    @Preview
    @Composable
    fun MainUI() {
        Content()
    }
}