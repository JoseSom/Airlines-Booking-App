package mx.jsomven

import mx.jsomven.data.aircraft.AirCraftLocalSource
import mx.jsomven.data.airport.AirportLocalSource
import mx.jsomven.data.airportbook.AirportBookingLocalSource
import mx.jsomven.data.baggage.BaggageRegularLocalSource
import mx.jsomven.data.baggage.BaggageVClubLocalSource
import mx.jsomven.data.flight.FlightLocalSource
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.model.baggage.type.BaggageType
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.domain.usecases.baggage.GetBaggagePackage
import mx.jsomven.domain.usecases.flight.GetFlights
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.baggage.BaggagePackageConsole
import mx.jsomven.presentation.baggage.types.BaggageTypesConsole
import mx.jsomven.presentation.flight.FlightPresentationFactory
import java.time.Month

fun main() {
    val vClubLocalSource = BaggageVClubLocalSource()
    val regularLocalSource = BaggageRegularLocalSource()

    val getVClubPackage = GetBaggagePackage(regularLocalSource).invoke()

    println("*** Vclub Baggage's ***")
    getVClubPackage.forEach { (t,u) ->
        println("$t.")
        println(
            BaggagePackageConsole(
                BaggageTypesConsole()
            ).format(u)
        )
    }
}

