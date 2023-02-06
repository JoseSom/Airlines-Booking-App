package mx.jsomven.domain.model

import mx.jsomven.domain.model.seat.SeatSection

data class AirCraft(
    val name: String,
    val model: String,
    val seatSections: List<SeatSection>,
    val airline: Airline = Airline("VL", "Volaris")
)