package mx.jsomven

import mx.jsomven.data.baggage.BaggageRegularLocalSource
import mx.jsomven.data.baggage.BaggageVClubLocalSource
import mx.jsomven.domain.datasource.baggage.BaggagePackageDataSource
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.model.baggage.pack.BaggagePackage
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.domain.usecases.baggage.GetBaggagePackage
import mx.jsomven.domain.usecases.baggage.GetBaggageSaved
import mx.jsomven.domain.usecases.flight.GetFlightSaved
import mx.jsomven.domain.usecases.flight.GetFlights
import mx.jsomven.domain.usecases.flight.di.FlightDataDI
import mx.jsomven.domain.usecases.ticket.AsiggBaggagePackToTicket
import mx.jsomven.domain.usecases.ticket.AssignFlightToTicket
import mx.jsomven.domain.usecases.ticket.di.TicketDataDI
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.baggage.BaggagePackPresentationFactory
import mx.jsomven.presentation.baggage.BaggagePackageConsole
import mx.jsomven.presentation.baggage.BaggagePackageEnum
import mx.jsomven.presentation.baggage.types.BaggageTypesConsole
import mx.jsomven.presentation.flight.FlightPresentationFactory
import mx.jsomven.presentation.flight.formats.FlightCosoleFormat
import mx.jsomven.presentation.menu.UIMenu
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val ticketData = TicketDataDI().providesTicketsData()
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePackPresentation = BaggagePackPresentationFactory().getPresentationFormat(format)

    /** 1. Showing Flight List */
    val uiMenuFlight = object : UIMenu<Flight> {}
    val flightData = FlightDataDI().providesFlightsData()
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(
        flightsMap, flightsPresentation
    )

    /** 2. Saving Flight in Ticket */
    AssignFlightToTicket(ticketData).invoke(flightSelected)

    val flightSaved = GetFlightSaved(ticketData).invoke()

    println("Flight Saved")
    println(
        flightsPresentation.format(flightSaved)
    )

    /** 3. Showing Baggage Packages */

    val baggagePackOptions = mapOf(
        1 to BaggagePackageEnum.Regular,
        2 to BaggagePackageEnum.VClub
    )

    val uiMenuBaggagePackOpt = object : UIMenu<BaggagePackageEnum> {}
    val baggagePackageOption = uiMenuBaggagePackOpt.showMenu(baggagePackOptions, object :
        Formatter<BaggagePackageEnum> {
        override fun format(t: BaggagePackageEnum): String = t.name
    })

    val baggagePackData = when (baggagePackageOption) {
        BaggagePackageEnum.Regular -> BaggageRegularLocalSource()
        BaggagePackageEnum.VClub -> BaggageVClubLocalSource()
        else -> BaggageRegularLocalSource()
    }

    val baggagePacksMap = GetBaggagePackage(baggagePackData).invoke()
    val uiMenuBaggagePack = object : UIMenu<BaggagePackage> {}
    val baggagePackageSelected = uiMenuBaggagePack.showMenu(
        baggagePacksMap, baggagePackPresentation
    )


    /** 4. Saving Baggage in Ticket */
    AsiggBaggagePackToTicket(ticketData).invoke(baggagePackageSelected)

    val baggageSaved = GetBaggageSaved(ticketData).invoke()

    println("Baggage Package Saved")
    println(
        baggagePackPresentation.format(baggageSaved)
    )
}

