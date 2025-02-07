import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.IntOffset
import java.awt.image.BufferedImage
import kotlin.math.roundToInt

class DrawContext {
    private val pixels = mutableListOf<Pair<IntOffset, Color>>()
    fun setPixel(x: Int, y: Int, color: Color = Color.Black) {
        pixels.add(IntOffset(x, y) to color)
    }

    fun _draw(canvas: DrawScope) {

        val width = 500
        val height = 500
        val bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

        repeat(width) { i ->
            repeat(height) { j ->
                bufferedImage.raster.setPixel(i, j, Color.White.toIntArray())
            }
        }

        for ((pixel, color) in pixels) {
            bufferedImage.raster.setPixel(pixel.x, pixel.y, color.toIntArray())
        }

        val imageBitmap = bufferedImage.toComposeImageBitmap()

        canvas.drawImage(imageBitmap)
    }
}


private fun Color.toIntArray() = intArrayOf(
    (red * 255).roundToInt(),
    (green * 255).roundToInt(),
    (blue * 255).roundToInt()
)
