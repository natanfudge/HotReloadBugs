import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.delay
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import java.awt.image.BufferedImage
import kotlin.math.roundToInt


@Composable
@Preview
fun App() {
    DevelopmentEntryPoint {
        var value by remember { mutableStateOf(false) }
        LaunchedEffect(Unit) {
            while (true) {
                delay(100)
                value = !value
            }
        }
        Canvas(modifier = Modifier.size(500.dp)) {

            value
            DrawContext().apply {
                drawMain()

                _draw(this@Canvas)
            }
        }
    }
}




fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
