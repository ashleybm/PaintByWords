package com.copeac.paintbywords.model

import java.awt.Color
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

    /**
     * Converts a specifically formatted csv file.
     * Row 0: Creator Credit
     * Row 1 -> inf: [column, row]
     * Produces a Buffered Image, and Progressed Picture for the Picture class.
     */
    fun convertCSVtoProgressedPicture(csvFilePath: String): Pair<List<List<String>>, BufferedImage> {
        val image = BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB)
        val graphics = image.createGraphics()
        var hexCodeReference = listOf<String>()
        val hexList = mutableListOf<MutableList<String>>()

        BufferedReader(FileReader(csvFilePath)).use { reader ->
            var y = -1
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                val values = line!!.split(",")
                if (y == -) {
                    hexCodeReference = values
                    y++
                    continue
                }
                var x = 0
                hexList.add(mutableListOf())
                for (value in values) {
                    val squareValue = value.trim().toInt()
                    val squareColor = hexCodeReference.getColorForSquare(squareValue) // Define the color based on the value
                    graphics.color = Color.decode(squareColor)
                    graphics.fillRect(x, y, 1, 1) // Draw a single pixel square
                    hexList[x].add(y, squareColor)
                    x++
                }
                y++
            }
        }
        xSize
        return Pair(hexList, image)
    }

    private fun List<String>.getColorForSquare(color: Int): String {
        return this[color]
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