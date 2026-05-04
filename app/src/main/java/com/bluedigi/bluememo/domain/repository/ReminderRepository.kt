package com.bluedigi.bluememo.domain.repository

import com.bluedigi.bluememo.domain.model.Reminder
import kotlinx.coroutines.flow.Flow

interface ReminderRepository {
    fun getReminders(): Flow<List<Reminder>>
    suspend fun createReminder(reminder: Reminder)
    suspend fun completeReminder(rememberId: Long)
}