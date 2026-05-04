package com.bluedigi.bluememo.feature.reminder.presentation

import com.bluedigi.bluememo.domain.model.ReminderFrequency

data class CreateReminderUiState(
    val title: String = "",
    val description: String = "",
    val frequency: ReminderFrequency = ReminderFrequency.ONCE,
    val titleError: String? = null
)
