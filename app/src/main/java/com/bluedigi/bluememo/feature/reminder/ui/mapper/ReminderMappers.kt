package com.bluedigi.bluememo.feature.reminder.ui.mapper


import com.bluedigi.bluememo.R
import com.bluedigi.bluememo.domain.model.ReminderFrequency
import com.bluedigi.bluememo.domain.model.ReminderStatus

fun mapStatusToStringRes(status: ReminderStatus): Int {
    return when (status) {
        ReminderStatus.ACTIVE -> R.string.status_active
        ReminderStatus.COMPLETED -> R.string.status_completed
        ReminderStatus.OVERDUE -> R.string.status_overdue
    }
}

fun mapFrequencyToStringRes(frequency: ReminderFrequency): Int {
    return when (frequency){
        ReminderFrequency.ONCE -> R.string.frequency_unique
        ReminderFrequency.DAILY -> R.string.frequency_daily
        ReminderFrequency.WEEKLY -> R.string.frequency_weekly
        ReminderFrequency.MONTHLY -> R.string.frequency_monthly
    }
}