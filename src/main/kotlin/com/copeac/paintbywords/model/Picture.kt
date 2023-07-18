package com.copeac.paintbywords.model

import java.awt.image.BufferedImage
import java.io.BufferedReader
import java.io.FileReader
import java.sql.Date

data class Picture(
    val id: String,
    val name: String,
    val xSize: Int,
    val ySize: Int,
    val imgCreator: String,
    val dateStarted: Date,
    val dateCompleted: Date?,
    val firstUser: String,
    val lastUser: String?,
    val reminderBankId: String,
    val progressedPicture: List<List<Int>>,
    var recentGeneration: BufferedImage
) {
    fun generateImage(): BufferedImage {
        val generateImage = BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB)


        recentGeneration = generateImage
        return recentGeneration
    }

    fun convertCSVtoProgressedPicture(csvFilePath: String): List<List<Int>> {
        val image = BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB)
        val graphics = image.createGraphics()

        BufferedReader(FileReader(csvFilePath)).use { reader ->
            var y = 0
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                val values = line!!.split(",")
                val pictureAsInts = values.map { wordCellCount ->
                    wordCellCount.toInt()

                }
                var x = 0
                for (value in values) {
                    val squareValue = value.trim().toInt()
                    val squareColor = getColorForSquare(squareValue) // Define the color based on the value
                    graphics.color = squareColor
                    graphics.fillRect(x, y, 1, 1) // Draw a single pixel square
                    x++
                }
                y++
            }
            return TODO()
        }
    }

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