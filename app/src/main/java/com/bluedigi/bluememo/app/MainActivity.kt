package com.bluedigi.bluememo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bluedigi.bluememo.core.designsystem.theme.BlueMemoTheme
import com.bluedigi.bluememo.di.AppContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlueMemoTheme {
                BlueMemoApp(
                    appContainer = AppContainer()
                )
            }
        }
    }
}