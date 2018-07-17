package tube
import com.fasterxml.jackson.annotation.JacksonAnnotation
import com.fasterxml.jackson.module.kotlin.*
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TubeClient(private val client: HttpHandler) {

    fun getNextArrivalTimeFor(line: TubeLine, stop: TubeStop) : LocalDateTime {

        val response = client(org.http4k.core.Request(Method.GET, "https://api.tfl.gov.uk/Line/$line/Arrivals/$stop"))

        val mapper = jacksonObjectMapper()

        val readValue = mapper.readValue<List<Map<String, Any>>>(response.bodyString())
        return LocalDateTime.parse(readValue.first()["expectedArrival"].toString(), DateTimeFormatter.ISO_DATE_TIME)
    }
}