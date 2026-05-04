package com.bluedigi.bluememo.domain.usecase

import com.bluedigi.bluememo.domain.model.Reminder
import com.bluedigi.bluememo.domain.repository.ReminderRepository
import kotlinx.coroutines.flow.Flow

class GetReminderUseCase(
    private val repository: ReminderRepository
) {
    operator fun invoke(): Flow<List<Reminder>> {
        return repository.getReminders()
    }
}