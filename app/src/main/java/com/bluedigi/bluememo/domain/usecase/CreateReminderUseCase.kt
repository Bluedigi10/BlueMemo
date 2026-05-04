package com.bluedigi.bluememo.domain.usecase

import com.bluedigi.bluememo.domain.model.Reminder
import com.bluedigi.bluememo.domain.repository.ReminderRepository

class CreateReminderUseCase(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(reminder: Reminder){
        repository.createReminder(reminder)
    }
}