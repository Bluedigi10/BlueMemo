package com.bluedigi.bluememo.di

import com.bluedigi.bluememo.data.local.ReminderLocalDataSource
import com.bluedigi.bluememo.data.preferences.UserPreferencesDataSource
import com.bluedigi.bluememo.data.repository.InMemoryReminderRepository
import com.bluedigi.bluememo.domain.repository.ReminderRepository
import com.bluedigi.bluememo.domain.usecase.GetReminderUseCase

object AppModule {
    val preferencesDataSource = UserPreferencesDataSource()

    private val reminderLocalDataSource = ReminderLocalDataSource()
    private val reminderRepository: ReminderRepository = InMemoryReminderRepository(
        localDataSource = reminderLocalDataSource
    )

    val getReminderUseCase = GetReminderUseCase(reminderRepository)
}