package com.bluedigi.bluememo.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = BluePrimary,
    secondary = BlueSecondary,
    background = BlueBackground,
    surface = BlueSurface,
    onPrimary = BlueOnPrimary,
    onBackground = BlueOnBackground
)

private val DarkColors = darkColorScheme()

@Composable
fun BlueMemoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}