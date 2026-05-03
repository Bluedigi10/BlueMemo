package com.bluedigi.bluememo.domain.repository

import com.bluedigi.bluememo.domain.model.Reminder

class FakeReminderRepository : ReminderRepository {
    override fun getReminders(): List<Reminder> {
        return emptyList()
    }
}