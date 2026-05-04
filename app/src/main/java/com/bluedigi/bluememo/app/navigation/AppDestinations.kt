package com.bluedigi.bluememo.navigation

sealed class AppDestinations(val route: String) {
    data object Home : AppDestinations("home")
    data object Reminder : AppDestinations("reminder")
    data object Settings : AppDestinations("settings")
}