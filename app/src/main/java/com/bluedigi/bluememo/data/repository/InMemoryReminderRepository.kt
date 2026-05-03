package com.bluedigi.bluememo.data.repository

import com.bluedigi.bluememo.data.local.ReminderLocalDataSource
import com.bluedigi.bluememo.domain.model.Reminder
import com.bluedigi.bluememo.domain.repository.ReminderRepository

class InMemoryReminderRepository(
    private val localDataSource: ReminderLocalDataSource
): ReminderRepository {
    override fun getReminders(): List<Reminder> = localDataSource.getReminders()
}