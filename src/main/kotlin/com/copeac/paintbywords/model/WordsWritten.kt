package com.copeac.paintbywords.model

import java.sql.Date

data class WordsWritten(
    val user: String,
    val words: Int,
    val date: Date,
    val pixelsColored: List<Pixel>,
    val remainderWords: Int
)