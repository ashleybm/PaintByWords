package com.copeac.paintbywords.model

import java.sql.Date

data class Picture(
    val id: String,
    val name: String,
    val xSize: Int,
    val ySize: Int,
    val imgCreator: String,
    val dateStarted: Date,
    val dateCompleted: Date,
    val firstUser: String,
    val lastUser: String
) {
    fun truePixelSizeX(): Int {
        return xSize
    }

    fun truePixelSizeY(): Int {
        return ySize
    }

    fun imgPixelSizeX(): Int {
        return xSize * 3
    }

    fun imgPixelSizeY(): Int {
        return ySize * 3
    }
}