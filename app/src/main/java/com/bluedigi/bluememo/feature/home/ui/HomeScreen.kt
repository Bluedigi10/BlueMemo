package com.bluedigi.bluememo.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bluedigi.bluememo.R
import com.bluedigi.bluememo.core.designsystem.component.BlueMemoPrimaryButton

@Composable
fun HomeScreen(
    onGoToReminder: () -> Unit,
    onGoToSettings: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(R.string.main_screen_title),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(R.string.home_empty_state),
            style = MaterialTheme.typography.bodyMedium
        )

        BlueMemoPrimaryButton(
            text = stringResource(R.string.go_to_reminder_text),
            onClick = onGoToReminder,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .widthIn(max = 320.dp)
        )

        BlueMemoPrimaryButton(
            text = stringResource(R.string.go_to_settings_text),
            onClick = onGoToSettings,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .widthIn(max = 320.dp)
        )
    }
}