package mx.jsomven.domain.usecases.flight

import mx.jsomven.domain.datasource.ticket.TicketDataSource
import mx.jsomven.domain.model.Flight

/**
 * Consultar vuelo
 */
class GetFlightSaved(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(): Flight {
        return ticketDataSource.tickets.first().flight
    }
}