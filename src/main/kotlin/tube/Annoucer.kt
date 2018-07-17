package tube

class Announcer(private val textToVoice: TextToVoice, private  val line: TubeLine, private val stop: TubeStop, private val tubeApi: HttpTubeClient) {
    fun go() {
        val nextArrivalTimeFor = tubeApi.getNextArrivalTimeFor(line, stop)
        Thread.sleep((nextArrivalTimeFor.time * 1000).toLong())
        textToVoice.announce("Your next train is here")
    }

}

data class TubeStop(val value: String)
data class TubeLine(val value: String)