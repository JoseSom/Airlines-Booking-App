package mx.jsomven

import mx.jsomven.data.aircraft.AirCraftLocalSource
import mx.jsomven.data.airport.AirportLocalSource
import mx.jsomven.data.airportbook.AirportBookingLocalSource
import mx.jsomven.data.baggage.BaggageRegularLocalSource
import mx.jsomven.data.baggage.BaggageVClubLocalSource
import mx.jsomven.data.flight.FlightLocalSource
import mx.jsomven.data.ticket.TicketListSingleton
import mx.jsomven.domain.datasource.baggage.BaggagePackageDataSource
import mx.jsomven.domain.usecases.baggage.GetBaggagePackage
import mx.jsomven.domain.usecases.flight.GetFlights
import mx.jsomven.domain.usecases.ticket.AssignFlightToTicket
import mx.jsomven.presentation.baggage.BaggagePackageConsole
import mx.jsomven.presentation.baggage.types.BaggageTypesConsole
import mx.jsomven.presentation.flight.formats.FlightCosoleFormat
import java.time.Month

fun main() {
    val airportDataSource = AirportLocalSource()
    val airportBookingLocalSource = AirportBookingLocalSource(airportDataSource)
    val airCraftLocalSource = AirCraftLocalSource()

    val flightLocal = FlightLocalSource(airCraftLocalSource, airportBookingLocalSource)
    val getFlights = GetFlights(flightLocal).invoke(Month.JANUARY)
    getFlights.forEach { (t, u) ->
        print("$t. ")
        println(FlightCosoleFormat().format(u))
    }

    println()

    val vClubLocalSource = BaggageVClubLocalSource()
    val getVClubPackages = GetBaggagePackage(vClubLocalSource).invoke()

    val regularLocalSource = BaggageRegularLocalSource()
    val getRegularPackages = GetBaggagePackage(regularLocalSource).invoke()

    println("*** VClub Baggage's ***")
    printBaggagePacksConsole(regularLocalSource)
    println()
    println("*** Regular Baggage's ***")
    printBaggagePacksConsole(vClubLocalSource)

    println()
    println("*** Flight Selected ***")
    val ticketSingleton = TicketListSingleton()
    val flight = getFlights[1]
    AssignFlightToTicket(ticketSingleton).invoke(flight)

    val flightSelected = ticketSingleton.tickets.first().flight
    println(
        FlightCosoleFormat().format(flightSelected)
    )
}

fun printBaggagePacksConsole(
    baggageDataSource: BaggagePackageDataSource
) {
    val getBaggagePackages = GetBaggagePackage(baggageDataSource).invoke()

    getBaggagePackages.forEach { (t, u) ->
        print("$t. ")
        println(BaggagePackageConsole(
            BaggageTypesConsole()
        ).format(u))
    }

}

