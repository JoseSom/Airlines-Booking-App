package mx.jsomven.data.airport

import mx.jsomven.domain.datasource.airport.AirportDataSource
import mx.jsomven.domain.model.Airport

class AirportLocalSource: AirportDataSource {
    override fun getAirports(): List<Airport> = listOf(
        Airport("QMX", "Mexico City"),
        Airport("CHI", "Chicago"),
        Airport("BOG", "Bogotá"),
        Airport("CUN", "Cancún"),
    )
}