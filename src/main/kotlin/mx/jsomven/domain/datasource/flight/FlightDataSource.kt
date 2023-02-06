package mx.jsomven.domain.datasource.flight

import mx.jsomven.domain.model.Flight

interface FlightDataSource {
    fun getFlights(): Map<Int,Flight>
}