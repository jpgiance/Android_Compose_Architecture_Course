package com.jorgegiance.myapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jorgegiance.myapplication.ui.main.MainScreen
import com.jorgegiance.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme  {
                MainScreen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
