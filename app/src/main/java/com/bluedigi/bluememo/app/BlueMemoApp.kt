package com.bluedigi.bluememo.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.bluedigi.bluememo.app.navigation.AppHostNav
import com.bluedigi.bluememo.di.AppContainer
import com.bluedigi.bluememo.feature.reminder.presentation.ReminderViewModelFactory

@Composable
fun BlueMemoApp(
    appContainer: AppContainer
) {
    val reminderViewModelFactory = remember {
        ReminderViewModelFactory(
            getReminderUseCase = appContainer.getReminderUseCase,
            createReminderUseCase = appContainer.createReminderUseCase,
            completeReminderUseCase = appContainer.completeReminderUseCase
        )
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        AppHostNav(
            navController = rememberNavController(),
            reminderViewModelFactory = reminderViewModelFactory,
            innerPadding = innerPadding)
    }
}