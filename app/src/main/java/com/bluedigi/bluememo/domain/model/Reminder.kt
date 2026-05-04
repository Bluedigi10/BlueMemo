package com.bluedigi.bluememo.domain.model

data class Reminder(
    val id: String,
    val title: String,
    val description: String? = null,
    val frequency: ReminderFrequency,
    val status: ReminderStatus,
    val createdAtMillis: Long
)
