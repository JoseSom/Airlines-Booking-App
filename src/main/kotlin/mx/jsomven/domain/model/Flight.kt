package mx.jsomven.domain.model

import mx.jsomven.domain.presentation.Formatter
import java.math.BigDecimal
import java.time.Duration
import java.time.format.DateTimeFormatter

data class Flight (
    val number: String,
    val airCraft: AirCraft,
    val price: BigDecimal,
    val departureArrivalBooking: Pair<AirportBooking,AirportBooking>,
    val duration: Duration = Duration.between(
        departureArrivalBooking.second.dateTime,
        departureArrivalBooking.first.dateTime
    )
): Formatter {
    override fun format(): String {
        val departure = departureArrivalBooking.first
        val arrival = departureArrivalBooking.second

        return """
            $number
            Origin ${departure.airport.name}
            Origin Date time ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival ${arrival.airport.name}        
            Arrival Date time ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Duration: $duration
            Price: $${price}
            
        """.trimIndent()
    }
}
