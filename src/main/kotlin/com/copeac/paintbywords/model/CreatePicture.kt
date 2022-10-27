package com.copeac.paintbywords.model

import java.sql.Date

data class CreatePicture(
    val name: String,
    val xPixelSize: Int,
    val yPixelSize: Int,
    val imgCreator: String,
) {
    fun truePixelSizeX(): Int {
        return xPixelSize
    }

    fun truePixelSizeY(): Int {
        return yPixelSize
    }

    fun imgPixelSizeX(): Int {
        return xPixelSize * 3;
    }

    fun imgPixelSizeY(): Int {
        return yPixelSize * 3;
    }
}