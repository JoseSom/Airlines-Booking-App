package mx.jsomven

import mx.jsomven.data.baggage.BaggageRegularLocalSource
import mx.jsomven.data.baggage.BaggageVClubLocalSource
import mx.jsomven.domain.datasource.baggage.BaggagePackageDataSource
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.usecases.baggage.GetBaggagePackage
import mx.jsomven.domain.usecases.flight.GetFlightSaved
import mx.jsomven.domain.usecases.flight.GetFlights
import mx.jsomven.domain.usecases.flight.di.FlightDataDI
import mx.jsomven.domain.usecases.ticket.AssignFlightToTicket
import mx.jsomven.domain.usecases.ticket.di.TicketDataDI
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.baggage.BaggagePackageConsole
import mx.jsomven.presentation.baggage.types.BaggageTypesConsole
import mx.jsomven.presentation.flight.FlightPresentationFactory
import mx.jsomven.presentation.flight.formats.FlightCosoleFormat
import mx.jsomven.presentation.menu.UIMenu
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()

    val uiMenuFlight = object : UIMenu<Flight> {}
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(flightsMap, flightPresentation)

    val vClubLocalSource = BaggageVClubLocalSource()
    val getVClubPackages = GetBaggagePackage(vClubLocalSource).invoke()

    val regularLocalSource = BaggageRegularLocalSource()
    val getRegularPackages = GetBaggagePackage(regularLocalSource).invoke()

    AssignFlightToTicket(ticketData).invoke(flightSelected)
    val flightSaved = GetFlightSaved(ticketData).invoke()
    println(
        FlightCosoleFormat().format(flightSaved)
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

