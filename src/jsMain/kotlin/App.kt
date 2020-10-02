import kotlinx.css.*
import react.*
import react.dom.*
import styled.css
import styled.styledDiv
import styled.styledH1

external interface AppState : RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
    var watchedVideos: List<Video>
}

class App : RComponent<RProps, AppState>() {
    val counter = 34

    override fun AppState.init() {
        unwatchedVideos = listOf(
            Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
            Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
            Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
        )
        watchedVideos = listOf(
            Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
        )
    }

    override fun RBuilder.render() {
        styledH1 {
            +"Hello, person!"
            css {
                fontFamily = "sans-serif"
            }
        }
        div {
            li {
                +"Counts $counter"
            }

        }
        state.currentVideo?.let { currentVideo ->
            videoPlayer {
                video = currentVideo
                unwatchedVideo = currentVideo in state.unwatchedVideos
                onWatchedButtonPressed = {
                    if (video in state.unwatchedVideos) {
                        setState {
                            unwatchedVideos -= video
                            watchedVideos += video
                        }
                    } else {
                        setState {
                            watchedVideos -= video
                            unwatchedVideos += video
                        }
                    }
                }
            }
        }
        h3 {
            +"Videos to watch"
        }
        canvas("canvas") {


        }
        videoList {
            videos = state.unwatchedVideos
            selectedVideo = state.currentVideo
            onSelectVideo = { video ->
                setState {
                    currentVideo = video
                }
            }
        }

        h3 {
            +"Videos watched"
        }
        videoList {
            videos = state.watchedVideos
            selectedVideo = state.currentVideo
            onSelectVideo = { video ->
                setState {
                    currentVideo = video
                }
            }
        }

    }
}