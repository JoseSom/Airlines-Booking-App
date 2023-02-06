package mx.jsomven.domain.datasource.airportbook

import mx.jsomven.domain.model.AirportBooking

interface AirportBookingDataSource {
    fun getAirBookingPairs(): List<Pair<AirportBooking,AirportBooking>>
}