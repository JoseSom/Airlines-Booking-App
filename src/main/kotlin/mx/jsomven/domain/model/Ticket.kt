package mx.jsomven.domain.model

import mx.jsomven.domain.model.baggage.pack.BaggagePackage
import mx.jsomven.domain.model.seat.Seat
import mx.jsomven.domain.presentation.Formatter
import java.math.BigDecimal
import java.time.format.DateTimeFormatter

data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val baggagePackage: BaggagePackage,
    val seat: Seat,
    val totalPrice: BigDecimal = flight.price + baggagePackage.price + seat.price
): Formatter {
    override fun format(): String {
        return """
            Passenger: ${passenger.name}
            Flight Number: ${flight.number}
            Departure: ${flight.departureArrivalBooking.first.airport.name}
            Arrival: ${flight.departureArrivalBooking.second.airport.name}
            Flight Price: $${flight.price}
            Seat: ${seat.number}
            Total: $$totalPrice
            
        """.trimIndent()
    }
}
