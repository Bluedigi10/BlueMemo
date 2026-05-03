package com.bluedigi.bluememo.di

import com.bluedigi.bluememo.domain.repository.FakeReminderRepository
import com.bluedigi.bluememo.domain.repository.ReminderRepository
import com.bluedigi.bluememo.domain.usecase.GetReminderUseCase

object AppModule {
    private val reminderRepository: ReminderRepository = FakeReminderRepository()

    val getReminderUseCase = GetReminderUseCase(reminderRepository)
}