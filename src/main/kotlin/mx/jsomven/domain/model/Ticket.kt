package mx.jsomven.domain.model

import mx.jsomven.domain.model.baggage.pack.BaggagePackage
import mx.jsomven.domain.model.seat.Seat
import mx.jsomven.domain.presentation.Formatter
import java.math.BigDecimal
import java.time.format.DateTimeFormatter

class Ticket {
    lateinit var flight: Flight
    lateinit var passenger: Passenger
    lateinit var baggagePackage: BaggagePackage
    lateinit var seat: Seat
    val totalPrice: BigDecimal
        get() {
            return if (this::flight.isInitialized)
                flight.price + baggagePackage.price + seat.price
            else BigDecimal(0)
        }
}
