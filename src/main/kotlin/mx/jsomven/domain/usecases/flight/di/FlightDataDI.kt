package mx.jsomven.domain.usecases.flight.di

import mx.jsomven.data.aircraft.AirCraftLocalSource
import mx.jsomven.data.airport.AirportLocalSource
import mx.jsomven.data.airportbook.AirportBookingLocalSource
import mx.jsomven.data.flight.FlightLocalSource
import mx.jsomven.domain.datasource.flight.FlightDataSource

class FlightDataDI {

    fun providesFlightsData(): FlightDataSource{
        val airportDataSource = AirportLocalSource()
        val airportBookingLocalSource = AirportBookingLocalSource(airportDataSource)
        val airCraftLocalSource = AirCraftLocalSource()

        return FlightLocalSource(
            airCraftLocalSource,
            airportBookingLocalSource
        )
    }
}