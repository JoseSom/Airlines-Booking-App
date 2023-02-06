package mx.jsomven

import mx.jsomven.domain.model.AirCraft
import mx.jsomven.domain.model.Airport
import mx.jsomven.domain.model.AirportBooking
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.domain.usecases.GetFlights
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.flight.FlightCosoleFormat
import mx.jsomven.presentation.flight.FlightHTMLFormat
import mx.jsomven.presentation.flight.FlightPresentationFactory
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightFormatted: Formatter<Flight> = FlightPresentationFactory().getPresentationFormat(format)
    val getFlights = GetFlights(flightFormatted).invoke()
    println(getFlights)
}

