import jquery.jq
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import react.dom.render
import kotlin.random.Random

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}

val canvas = initalizeCanvas()
fun initalizeCanvas(): HTMLCanvasElement {
    val canvas = document.createElement("canvas") as HTMLCanvasElement
    val context = canvas.getContext("2d") as CanvasRenderingContext2D
    context.canvas.width = window.innerWidth.toInt();
    context.canvas.height = window.innerHeight.toInt();
    document.body!!.appendChild(canvas)
    return canvas
}

class FancyLines() {
    val context = canvas.getContext("2d") as CanvasRenderingContext2D
    val height = canvas.height.toDouble()
    val width = canvas.width.toDouble()
    fun nextX() = Random.nextDouble(width)
    fun nextY() = Random.nextDouble(height)
    var x = nextX()
    var y = nextY()
    var hue = 0

    fun line() {
        context.save();

        context.beginPath();

        context.lineWidth = Random.nextDouble(20.0)
        context.moveTo(x, y);

        x = nextX()
        y = nextY()

        context.bezierCurveTo(
            nextX(), nextY(),
            nextX(), nextY(), x, y
        )

        hue += Random.nextInt(10)

        context.strokeStyle = "hsl($hue, 50%, 50%)";

        context.shadowColor = "white";
        context.shadowBlur = 10.0;

        context.stroke();

        context.restore();
    }

    fun blank() {
        context.fillStyle = "rgba(255,255,1,0.1)";
        context.fillRect(0.0, 0.0, width, height);
    }

    fun run() {
        window.setInterval({ line() }, 40);
        window.setInterval({ blank() }, 100);
    }
}

data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)