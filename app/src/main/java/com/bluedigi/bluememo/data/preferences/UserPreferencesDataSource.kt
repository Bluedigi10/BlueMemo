package com.bluedigi.bluememo.data.preferences

data class UserPreferences(
    val useDarkTheme: Boolean = false
)

class UserPreferencesDataSource{
    fun getPreferences(): UserPreferences = UserPreferences()
}
