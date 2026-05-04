package com.bluedigi.bluememo.feature.reminder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bluedigi.bluememo.R
import com.bluedigi.bluememo.domain.model.Reminder
import com.bluedigi.bluememo.domain.model.ReminderStatus
import com.bluedigi.bluememo.feature.reminder.ui.mapper.mapFrequencyToStringRes
import com.bluedigi.bluememo.feature.reminder.ui.mapper.mapStatusToStringRes

@Composable
fun ReminderItem(
    reminder: Reminder,
    onCompleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Checkbox(
                checked = reminder.status == ReminderStatus.COMPLETED,
                onCheckedChange = {
                    if (reminder.status != ReminderStatus.COMPLETED){
                        onCompleteClick()
                    }
                }
            )

            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = reminder.title
                )

                reminder.description?.let {
                    Text(
                        text = it
                    )
                }

                val frequencyString = stringResource(id = mapFrequencyToStringRes(reminder.frequency))

                Text(
                    text = stringResource(R.string.frequency_detail_text, frequencyString)
                )

                val statusString = stringResource(id = mapStatusToStringRes(reminder.status))

                Text(
                    text = stringResource(R.string.status_detail_text, statusString)
                )
            }
        }
    }
}