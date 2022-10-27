package com.copeac.paintbywords.model

data class pixel(
    val id: Int,
    val hexCode: String,
    val filled: Boolean,
    val pixelPositionX: Int,
    val pixelPositionY: Int
)