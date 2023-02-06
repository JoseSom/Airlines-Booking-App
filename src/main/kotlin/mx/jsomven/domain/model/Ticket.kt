package mx.jsomven.domain.model

import mx.jsomven.domain.model.seat.Seat

data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val baggagePackage: BaggagePackage,
    val seat: Seat
)
