package mx.jsomven.domain.usecases.flight

import mx.jsomven.domain.datasource.flight.FlightDataSource
import mx.jsomven.domain.model.AirCraft
import mx.jsomven.domain.model.Airport
import mx.jsomven.domain.model.AirportBooking
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.model.seat.SeatSection
import mx.jsomven.domain.presentation.Formatter
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

/**
 * Mostrar los vuelos disponible de un solo mes
 */
class GetFlights(
    private val flightDataSource: FlightDataSource
) {
    fun invoke(month: Month): Map<Int, Flight> {
        return flightDataSource
            .getFlights()
            .filter { flightEntry ->
                flightEntry.value.departureArrivalBooking.first.dateTime.month == month
            }
    }
}