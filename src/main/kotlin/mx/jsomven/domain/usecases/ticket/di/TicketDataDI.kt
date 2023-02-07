package mx.jsomven.domain.usecases.ticket.di

import mx.jsomven.data.ticket.TicketListSingleton
import mx.jsomven.domain.datasource.ticket.TicketDataSource

class TicketDataDI {
    fun providesTicketsData(): TicketDataSource {
        return TicketListSingleton()
    }
}