package mx.jsomven.domain.usecases.flight

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
class GetFlights() {
    fun invoke(month: Month): Map<Int, Flight> {
        val flight = Flight(
            number = "Y4 708",
            airCraft = AirCraft("Airbus", "A320", seatSections = listOf()),
            price = BigDecimal(100.0),
            departureArrivalBooking = getAirportPair()
        )

        val flightsMap = mapOf(
            1 to flight
        )

        return flightsMap.filter { flightEntry ->
            flightEntry.value.departureArrivalBooking.first.dateTime.month == month
        }
    }

    private fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
        return Pair(
            AirportBooking(
                airport = Airport("BOG", "Bogota"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY, 10, 13, 0, 0
                )
            ),
            AirportBooking(
                airport = Airport("CUN", "Cancun"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY, 10, 17, 30, 0
                )
            )
        )
    }
}