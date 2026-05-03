package com.bluedigi.bluememo.domain.repository

import com.bluedigi.bluememo.domain.model.Reminder

interface ReminderRepository {
    fun getReminders(): List<Reminder>
}