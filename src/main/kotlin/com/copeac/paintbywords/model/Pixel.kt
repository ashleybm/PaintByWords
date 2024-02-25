package com.copeac.paintbywords.model

data class Pixel( // pk; (imageId, pixelPositionX, pixelPositionY)
    val pictureId: Int,
    val hexCode: String,
    val filled: Boolean,
    val pixelPositionX: Int,
    val pixelPositionY: Int
)