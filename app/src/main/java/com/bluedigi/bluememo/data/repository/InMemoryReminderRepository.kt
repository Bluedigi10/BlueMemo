package com.bluedigi.bluememo.data.repository

import com.bluedigi.bluememo.domain.model.Reminder
import com.bluedigi.bluememo.domain.model.ReminderStatus
import com.bluedigi.bluememo.domain.repository.ReminderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InMemoryReminderRepository : ReminderRepository {
    private val reminders = MutableStateFlow<List<Reminder>>(emptyList())

    override fun getReminders(): Flow<List<Reminder>> {
        return reminders.asStateFlow()
    }

    override suspend fun createReminder(reminder: Reminder) {
        reminders.update { currentList ->
            currentList + reminder
        }
    }

    override suspend fun completeReminder(rememberId: String) {
        reminders.update { currentList ->
            currentList.map { reminder ->
                if (reminder.id == rememberId) {
                    reminder.copy(status = ReminderStatus.COMPLETED)
                } else {
                    reminder
                }
            }
        }
    }
}