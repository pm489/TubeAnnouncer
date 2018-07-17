package intergration

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.greaterThan
import org.http4k.client.ApacheClient
import org.junit.Test
import tube.HttpTubeClient
import tube.TubeLine
import tube.TubeStop

class TubeClientTest{

    @Test
    fun `can get next time from tfl api`() {

        val tubeClient = HttpTubeClient(ApacheClient())

        val nextArrivalTimeFor = tubeClient.getNextArrivalTimeFor(TubeLine("northern"), TubeStop("940GZZLUEUS"))

        assertThat(nextArrivalTimeFor.time, greaterThan(0))
    }
}