package mx.jsomven.domain.usecases

import mx.jsomven.domain.model.AirCraft
import mx.jsomven.domain.model.Airport
import mx.jsomven.domain.model.AirportBooking
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.presentation.Formatter
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

class GetFlights(
    private val formatter: Formatter<Flight>
) {
    fun invoke(): String{
        val flight = Flight(
            number = "Y4 708",
            airCraft = AirCraft("Airbus","A320"),
            price = BigDecimal(100.0),
            departureArrivalBooking = getAirportPair()
        )

        return formatter.format(flight)
    }

    private fun getAirportPair(): Pair<AirportBooking, AirportBooking>{
        return Pair(
            AirportBooking(
                airport = Airport("BOG","Bogota"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY,10,13,0,0
                )
            ),
            AirportBooking(
                airport = Airport("CUN","Cancun"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY,10,17, 30,0
                )
            )
        )
    }
}