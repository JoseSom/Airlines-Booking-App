package mx.jsomven.domain.datasource.airport

import mx.jsomven.domain.model.Airport

interface AirportDataSource {
    fun getAirports(): List<Airport>
}