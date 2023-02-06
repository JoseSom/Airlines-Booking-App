package mx.jsomven

import mx.jsomven.domain.model.AirCraft
import mx.jsomven.domain.model.Airport
import mx.jsomven.domain.model.AirportBooking
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.usecases.GetFlights
import mx.jsomven.presentation.flight.FlightCosoleFormat
import mx.jsomven.presentation.flight.FlightHTMLFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {
    val flightFormatted = GetFlights(FlightHTMLFormat()).invoke()
    println(flightFormatted)
}

