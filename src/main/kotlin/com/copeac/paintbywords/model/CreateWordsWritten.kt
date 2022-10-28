package com.copeac.paintbywords.model

import java.sql.Date

data class CreateWordsWritten(
    val user: String,
    val words: Int,
    val date: Date
)