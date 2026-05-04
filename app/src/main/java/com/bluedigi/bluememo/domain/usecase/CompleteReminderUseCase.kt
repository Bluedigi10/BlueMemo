package com.bluedigi.bluememo.domain.usecase

import com.bluedigi.bluememo.domain.repository.ReminderRepository

class CompleteReminderUseCase(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(reminderId: Long){
        repository.completeReminder(reminderId)
    }
}