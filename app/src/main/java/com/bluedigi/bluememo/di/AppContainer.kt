package com.bluedigi.bluememo.di

import com.bluedigi.bluememo.data.repository.InMemoryReminderRepository
import com.bluedigi.bluememo.domain.repository.ReminderRepository
import com.bluedigi.bluememo.domain.usecase.CompleteReminderUseCase
import com.bluedigi.bluememo.domain.usecase.CreateReminderUseCase
import com.bluedigi.bluememo.domain.usecase.GetReminderUseCase

class AppContainer {
    private val reminderRepository: ReminderRepository = InMemoryReminderRepository()

    val getReminderUseCase = GetReminderUseCase(reminderRepository)
    val createReminderUseCase = CreateReminderUseCase(reminderRepository)
    val completeReminderUseCase = CompleteReminderUseCase(reminderRepository)
}