package com.bluedigi.bluememo.feature.reminder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluedigi.bluememo.domain.model.Reminder
import com.bluedigi.bluememo.domain.model.ReminderFrequency
import com.bluedigi.bluememo.domain.model.ReminderStatus
import com.bluedigi.bluememo.domain.usecase.CompleteReminderUseCase
import com.bluedigi.bluememo.domain.usecase.CreateReminderUseCase
import com.bluedigi.bluememo.domain.usecase.GetReminderUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.UUID

class ReminderViewModel(
    private val getReminderUseCase: GetReminderUseCase,
    private val createReminderUseCase: CreateReminderUseCase,
    private val completeReminderUseCase: CompleteReminderUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ReminderUiState())
    val uiState: StateFlow<ReminderUiState> = _uiState.asStateFlow()

    private val _createState = MutableStateFlow(CreateReminderUiState())
    val createState: StateFlow<CreateReminderUiState> = _createState.asStateFlow()

    init {
        observeReminders()
    }

    private fun observeReminders() {
        viewModelScope.launch {
            getReminderUseCase().collect { reminders ->
                _uiState.value = ReminderUiState(
                    reminders = reminders,
                    isLoading = false
                )
            }
        }
    }

    fun onTitleChange(value: String) {
        _createState.value = _createState.value.copy(
            title = value,
            titleError = null
        )
    }

    fun onDescriptionChange(value: String) {
        _createState.value = _createState.value.copy(
            description = value
        )
    }

    fun onFrequencyChange(value: ReminderFrequency) {
        _createState.value = _createState.value.copy(
            frequency = value
        )
    }

    fun createReminder(onSuccess: () -> Unit) {
        val currentState = _createState.value

        if (currentState.title.isBlank()) {
            _createState.value = currentState.copy(
                titleError = "El título es obligatorio"
            )
            return
        }

        val reminder = Reminder(
            id = UUID.randomUUID().toString(),
            title = currentState.title.trim(),
            description = currentState.description.trim().ifBlank { null },
            frequency = currentState.frequency,
            status = ReminderStatus.ACTIVE,
            createdAtMillis = System.currentTimeMillis()
        )

        viewModelScope.launch {
            createReminderUseCase(reminder)
            clearCreateState()
            onSuccess()
        }
    }

    fun completeReminder(reminderId: String){
        viewModelScope.launch {
            completeReminderUseCase(reminderId)
        }
    }

    private fun clearCreateState(){
        _createState.value = CreateReminderUiState()
    }
}