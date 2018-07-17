package functional

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo

class AnnouncerTest{

    @org.junit.Test
    fun `can call announce`() {
        val textToVoice  = FakeTextToVoice()

        Announcer(textToVoice, TubeLine("what-ever"), TubeStop("some-stop")).go()

        assertThat(textToVoice.called, equalTo(1))
    }
}

class Announcer(val textToVoice: TextToVoice, val line: TubeLine, val stop: TubeStop) {
    fun go() {
        textToVoice.announce("Next train has arrived")
    }

}

data class TubeStop(val value: String)

data class TubeLine(val value: String)

interface TextToVoice {
    fun announce(text: String)
}

class FakeTextToVoice : TextToVoice {
    var called = 0
    override fun announce(text: String) {
        called++
    }
}