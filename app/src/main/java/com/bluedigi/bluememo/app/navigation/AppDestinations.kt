package com.bluedigi.bluememo.app.navigation

sealed class AppDestinations(val route: String) {
    data object Home : AppDestinations("home")
    data object Reminder : AppDestinations("reminders")
    data object CreateReminder : AppDestinations("create_reminder")
    data object Settings : AppDestinations("settings")
}