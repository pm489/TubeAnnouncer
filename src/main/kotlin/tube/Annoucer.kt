package tube

class Announcer(val textToVoice: TextToVoice, val line: TubeLine, val stop: TubeStop) {
    fun go() {
        textToVoice.announce("Next train has arrived")
    }

}

data class TubeStop(val value: String)
data class TubeLine(val value: String)