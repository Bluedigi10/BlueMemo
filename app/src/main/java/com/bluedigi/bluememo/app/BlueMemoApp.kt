package com.bluedigi.bluememo.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bluedigi.bluememo.navigation.AppHostNav

@Composable
fun BlueMemoApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        AppHostNav(innerPadding = innerPadding)
    }
}