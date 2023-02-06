package mx.jsomven

import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.domain.usecases.flight.GetFlights
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.flight.FlightPresentationFactory

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightFormatted: Formatter<Flight> = FlightPresentationFactory().getPresentationFormat(format)
    val getFlights = GetFlights(flightFormatted).invoke()
    println(getFlights)
}

