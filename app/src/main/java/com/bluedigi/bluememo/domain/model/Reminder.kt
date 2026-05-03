package com.bluedigi.bluememo.domain.model

data class Reminder(
    val id: Long,
    val title: String,
    val description: String? = null,
    val completed: Boolean = false
)
