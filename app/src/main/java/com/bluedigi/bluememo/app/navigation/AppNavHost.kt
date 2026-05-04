package com.bluedigi.bluememo.app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bluedigi.bluememo.feature.home.ui.HomeScreen
import com.bluedigi.bluememo.feature.reminder.ui.ReminderScreen
import com.bluedigi.bluememo.feature.settings.ui.SettingsScreen

@Composable
fun AppHostNav(
    innerPadding: PaddingValues
) {
    val navController = rememberNavController()

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
            ReminderScreen(
                onBack = {navController.popBackStack()}
            )
        }

        composable(AppDestinations.Settings.route) {
            SettingsScreen(
                onBack = {navController.popBackStack()}
            )
        }
    }
}