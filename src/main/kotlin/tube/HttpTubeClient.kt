package tube
import com.fasterxml.jackson.module.kotlin.*
import org.http4k.core.HttpHandler
import org.http4k.core.Method


class HttpTubeClient(private val client: HttpHandler) {

    fun getNextArrivalTimeFor(line: TubeLine, stop: TubeStop) : TimeToLocation {

        val response = client(org.http4k.core.Request(Method.GET, "https://api.tfl.gov.uk/Line/${line.value}/Arrivals/${stop.value}"))

        val mapper = jacksonObjectMapper()

        val readValue = mapper.readValue<List<Map<String, Any>>>(response.bodyString())
        return TimeToLocation(readValue.first()["timeToStation"].toString().toInt())
    }
}

data class TimeToLocation(val time: Int)