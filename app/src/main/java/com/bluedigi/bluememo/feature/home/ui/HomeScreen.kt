package com.bluedigi.bluememo.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bluedigi.bluememo.R

@Composable
fun HomeScreen(
    onGoToReminder: () -> Unit,
    onGoToSettings: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
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

        Button(
            onClick = onGoToReminder,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(stringResource(R.string.go_to_reminder_text))
        }

        Button(
            onClick = onGoToSettings,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text(stringResource(R.string.go_to_settings_text))
        }
    }
}