package unit

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.Response
import org.http4k.core.Status
import org.junit.Test
import tube.TubeClient
import tube.TubeLine
import tube.TubeStop
import java.time.LocalDateTime
import java.time.Month

class TubeClientTest{
    @Test
    fun `can return first LocalDateTime for train`() {
        val tubeClient = TubeClient({ r -> Response(Status.OK).body(String(this.javaClass.getResourceAsStream("/nextTube.json").readBytes())) })

        val nextArrivalTimeFor = tubeClient.getNextArrivalTimeFor(TubeLine("someLine"), TubeStop("someStop"))

        assertThat(nextArrivalTimeFor, equalTo(LocalDateTime.of(2018, Month.JULY,17, 16, 12, 7)))

    }
}