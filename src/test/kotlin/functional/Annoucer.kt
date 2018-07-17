package functional

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import tube.*

class AnnouncerTest{

    @org.junit.Test
    fun `can call announce at the correct time`() {
        val fakeTextToVoice  = FakeTextToVoice()
        val tubeApi = TubeClient({ _: Request -> Response(Status.OK).body("") })
        Announcer(fakeTextToVoice, TubeLine("what-ever"), TubeStop("some-stop")).go()

        assertThat(fakeTextToVoice.called, equalTo(1))
    }
}


class FakeTextToVoice : TextToVoice {
    var called = 0
    override fun announce(text: String) {
        called++
    }
}