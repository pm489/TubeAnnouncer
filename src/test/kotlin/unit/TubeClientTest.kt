package unit

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.Response
import org.http4k.core.Status
import org.junit.Test
import tube.TimeToLocation
import tube.HttpTubeClient
import tube.TubeLine
import tube.TubeStop

class TubeClientTest{
    @Test
    fun `can return first LocalDateTime for train`() {
        val tubeClient = HttpTubeClient({ r -> Response(Status.OK).body(String(this.javaClass.getResourceAsStream("/nextTube.json").readBytes())) })

        val nextArrivalTimeFor = tubeClient.getNextArrivalTimeFor(TubeLine("someLine"), TubeStop("someStop"))

        assertThat(nextArrivalTimeFor, equalTo(TimeToLocation(1)))

    }
}