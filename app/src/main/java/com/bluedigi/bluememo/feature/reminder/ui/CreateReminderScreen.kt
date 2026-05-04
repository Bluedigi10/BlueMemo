package com.bluedigi.bluememo.feature.reminder.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bluedigi.bluememo.R
import com.bluedigi.bluememo.core.designsystem.component.BlueMemoPrimaryButton
import com.bluedigi.bluememo.domain.model.ReminderFrequency
import com.bluedigi.bluememo.feature.reminder.presentation.CreateReminderUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateReminderScreen(
    uiState: CreateReminderUiState,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onFrequencyChange: (ReminderFrequency) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.create_reminder_text)
        )

        OutlinedTextField(
            value = uiState.title,
            onValueChange = onTitleChange,
            label = { Text(stringResource(R.string.title_text))},
            isError = uiState.titleError != null,
            supportingText = {
                uiState.titleError?.let {
                    Text(text = it)
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        )

        OutlinedTextField(
            value = uiState.description,
            onValueChange = onDescriptionChange,
            label = { Text(stringResource(R.string.description_text))},
            modifier = Modifier.padding(top = 12.dp)
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded},
            modifier = Modifier.padding(top = 12.dp)
        ) {
            OutlinedTextField(
                value = uiState.frequency.name,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(R.string.frequency_text))},
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.menuAnchor(
                    type = ExposedDropdownMenuAnchorType.PrimaryNotEditable,
                    enabled = true
                )
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false}
            ) {
                ReminderFrequency.entries.forEach { frequency ->
                    DropdownMenuItem(
                        text = { Text(frequency.name)},
                        onClick = {
                            onFrequencyChange(frequency)
                            expanded = false
                        }
                    )
                }
            }
        }

        BlueMemoPrimaryButton(
            text = stringResource(R.string.save_text),
            onClick = onSaveClick,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}