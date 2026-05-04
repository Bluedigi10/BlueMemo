package com.bluedigi.bluememo.app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bluedigi.bluememo.feature.home.ui.HomeScreen
import com.bluedigi.bluememo.feature.reminder.presentation.ReminderViewModel
import com.bluedigi.bluememo.feature.reminder.presentation.ReminderViewModelFactory
import com.bluedigi.bluememo.feature.reminder.ui.CreateReminderScreen
import com.bluedigi.bluememo.feature.reminder.ui.ReminderScreen
import com.bluedigi.bluememo.feature.settings.ui.SettingsScreen

@Composable
fun AppHostNav(
    navController: NavHostController,
    reminderViewModelFactory: ReminderViewModelFactory,
    innerPadding: PaddingValues
) {
    val reminderViewModel: ReminderViewModel = viewModel(
        factory = reminderViewModelFactory
    )

    NavHost(
        navController = navController,
        startDestination = AppDestinations.Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(AppDestinations.Home.route) {
            HomeScreen(
                onGoToReminder = {
                    navController.navigate(AppDestinations.Reminder.route)
                },
                onGoToSettings = {
                    navController.navigate(AppDestinations.Settings.route)
                }
            )
        }

        composable(AppDestinations.Reminder.route) {
            val uiState by reminderViewModel.uiState.collectAsState()
            ReminderScreen(
                uiState = uiState,
                onCreateReminderClick = {
                    navController.navigate(AppDestinations.CreateReminder.route)
                },
                onCompleteReminderClick = { reminderId ->
                    reminderViewModel.completeReminder(reminderId)
                },
                onBack = {navController.popBackStack()}
            )
        }

        composable(AppDestinations.CreateReminder.route) {
            val createState by reminderViewModel.createState.collectAsState()

            CreateReminderScreen(
                uiState = createState,
                onTitleChange = reminderViewModel::onTitleChange,
                onDescriptionChange = reminderViewModel::onDescriptionChange,
                onFrequencyChange = reminderViewModel::onFrequencyChange,
                onSaveClick = {
                    reminderViewModel.createReminder (
                        onSuccess = {
                            navController.popBackStack()
                        }
                    )
                }
            )
        }

        composable(AppDestinations.Settings.route) {
            SettingsScreen(
                onBack = {navController.popBackStack()}
            )
        }
    }
}