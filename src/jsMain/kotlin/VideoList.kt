import kotlinx.browser.window
import kotlinx.css.canvas
import kotlinx.html.CANVAS
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

external interface VideoListProps : RProps {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}


class VideoList : RComponent<VideoListProps, RState>() {
    override fun RBuilder.render() {
        for (video in props.videos) {
            p {
                key = video.id.toString()
                attrs {
                    onClickFunction = {
                        props.onSelectVideo(video)
                    }
                }
                if (video == props.selectedVideo) {
                    +"▶ "
                }
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class) {
        this.attrs(handler)
    }
}

//class CanvasComponent : RComponent<RProps, RState>() {
//    var ctx: RContext<CANVAS>? = null
//    override fun RBuilder.render() {
//        canvas {
//            ctx = createContext(this.attrs)
//
//        }
//    }
//
//    override fun componentDidMount() {
//        super.componentDidMount()
//        this.updateCanvas()
//    }
//
//    fun updateCanvas() {
////        ctx.
////        ctx.fillRect(0, 0, 100, 100);
//    }
//}