package mx.jsomven.domain.datasource.aircraft

import mx.jsomven.domain.model.AirCraft

interface AirCraftDataSource {
    fun getAirCrafts(): List<AirCraft>
}