import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.compose.reload.DevelopmentEntryPoint

var global = 0


@Composable
@Preview
fun App() {
    DevelopmentEntryPoint {
//        Box(modifier = Modifier.size(500.dp)) {
        Canvas(modifier = Modifier.size(500.dp)) {
            Test.setGlobalObject()
//            setGlobalNoObject()
            println("Global: $global")
        }
    }
}

fun setGlobalNoObject() {
    global = 5
}

object Test {
    fun setGlobalObject() {
        global = 5
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
