import org.http4k.client.ApacheClient
import tube.*

fun main(args: Array<String>) {
    val announcer = Announcer(SoutTextToVoice(), TubeLine("northern"), TubeStop("940GZZLUEUS"), HttpTubeClient(ApacheClient()))
    announcer.go()
}

class SoutTextToVoice : TextToVoice {
    override fun announce(text: String) {
        println(text)
    }
}