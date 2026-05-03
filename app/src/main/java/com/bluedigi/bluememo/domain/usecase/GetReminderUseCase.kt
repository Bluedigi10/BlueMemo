package com.bluedigi.bluememo.domain.usecase

import com.bluedigi.bluememo.domain.repository.ReminderRepository

class GetReminderUseCase(
    private val repository: ReminderRepository
) {
    operator fun invoke() = repository.getReminders()
}