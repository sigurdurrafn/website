import kotlinx.css.*
import react.dom.*
import styled.*
import kotlinx.browser.document

fun main() {
    val counter = 34
    render(document.getElementById("root")) {

        styledH1 {
            +"Hello, person!"
            css{
                fontFamily = "sans-serif"
            }
        }
        div {
            li {
                + "Counts $counter"

            }

        }
        styledDiv {
            css {
              position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                +"John Doe: Building and breaking things"
            }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
        for(video in unwatchedVideos) {
            p {
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

val unwatchedVideos = listOf(
    Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
    Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
    Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
)

val watchedVideos = listOf(
    Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
)
data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)