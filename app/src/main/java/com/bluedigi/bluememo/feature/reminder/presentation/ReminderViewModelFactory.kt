package com.bluedigi.bluememo.feature.reminder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bluedigi.bluememo.domain.usecase.CompleteReminderUseCase
import com.bluedigi.bluememo.domain.usecase.CreateReminderUseCase
import com.bluedigi.bluememo.domain.usecase.GetReminderUseCase

class ReminderViewModelFactory(
    private val getReminderUseCase: GetReminderUseCase,
    private val createReminderUseCase: CreateReminderUseCase,
    private val completeReminderUseCase: CompleteReminderUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReminderViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ReminderViewModel(
                getReminderUseCase = getReminderUseCase,
                createReminderUseCase = createReminderUseCase,
                completeReminderUseCase = completeReminderUseCase,
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}