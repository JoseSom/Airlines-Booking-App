package mx.jsomven.presentation.flight

import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.presentation.Formatter
import java.time.format.DateTimeFormatter

class FlightCosoleFormat: Formatter<Flight> {
    override fun format(t: Flight): String {
        val departure = t.departureArrivalBooking.first
        val arrival = t.departureArrivalBooking.second

        return """
            ${t.number}
            Origin ${departure.airport.name}
            Origin Date time ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival ${arrival.airport.name}        
            Arrival Date time ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Duration: ${t.duration}
            Price: $${t.price}
            
        """.trimIndent()
    }
}