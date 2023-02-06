package mx.jsomven

import mx.jsomven.domain.model.AirCraft
import mx.jsomven.domain.model.Airport
import mx.jsomven.domain.model.AirportBooking
import mx.jsomven.domain.model.Flight
import mx.jsomven.presentation.FlightCosoleFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {
    val flight = Flight(
        number = "Y4 708",
        airCraft = AirCraft("Airbus","A320"),
        price = BigDecimal(100.0),
        departureArrivalBooking = getAirportPair()
    )
    val flightFormatted = FlightCosoleFormat().format(flight)
    println(flightFormatted)
}

fun getAirportPair(): Pair<AirportBooking, AirportBooking>{
    return Pair(
        AirportBooking(
            airport = Airport("BOG","Bogota"),
            dateTime = LocalDateTime.of(
                2023,Month.JANUARY,10,13,0,0
            )
        ),
        AirportBooking(
            airport = Airport("CUN","Cancun"),
            dateTime = LocalDateTime.of(
                2023,Month.JANUARY,10,17, 30,0
            )
        )
    )
}