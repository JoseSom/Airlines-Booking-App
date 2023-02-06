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
)
