package com.bluedigi.bluememo.feature.reminder.presentation

import com.bluedigi.bluememo.domain.model.Reminder

data class ReminderUiState(
    val reminders: List<Reminder> = emptyList(),
    val isLoading: Boolean = false
)
