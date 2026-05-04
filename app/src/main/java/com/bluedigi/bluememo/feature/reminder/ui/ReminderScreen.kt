package com.bluedigi.bluememo.feature.reminder.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bluedigi.bluememo.R
import com.bluedigi.bluememo.core.designsystem.component.BlueMemoPrimaryButton
import com.bluedigi.bluememo.feature.reminder.presentation.ReminderUiState
import com.bluedigi.bluememo.feature.reminder.ui.components.ReminderItem

@Composable
fun ReminderScreen(
    uiState: ReminderUiState,
    onCreateReminderClick: () -> Unit,
    onCompleteReminderClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.reminder_list_title)
        )

        BlueMemoPrimaryButton(
            onClick = onCreateReminderClick,
            text = stringResource(R.string.new_reminder_text),
            modifier = Modifier.padding(top = 24.dp)
        )

        if (uiState.reminders.isEmpty()) {
            Text(
                text = stringResource(R.string.empty_reminders),
                modifier = Modifier.padding(top = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(uiState.reminders) { reminder ->
                    ReminderItem(
                        reminder = reminder,
                        onCompleteClick = {
                            onCompleteReminderClick(reminder.id)
                        }
                    )
                }
            }
        }
        BlueMemoPrimaryButton(
            text = stringResource(R.string.back_button_text),
            onClick = onBack,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
    }
}