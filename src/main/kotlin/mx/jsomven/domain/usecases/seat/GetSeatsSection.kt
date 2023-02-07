package mx.jsomven.domain.usecases.seat

import mx.jsomven.domain.model.seat.SeatSection
import mx.jsomven.domain.usecases.flight.GetFlightSaved

/**
 * Mostrar los asientos disponibles
 */
class GetSeatsSection(
    private val getFlightSaved: GetFlightSaved
) {
    operator fun invoke(): Map<Int, SeatSection> {
        val flight = getFlightSaved()
        val seatSectionsMap = flight
            .airCraft
            .seatSections
            .mapIndexed { index, seatSection ->
                index + 1 to seatSection
            }.toMap()
        return seatSectionsMap
    }
}