package mx.jsomven.domain.usecases.ticket

import mx.jsomven.domain.datasource.ticket.TicketDataSource
import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.model.Ticket

/**
 * Seleccionar un vuelo disponible
 */
class AssignFlightToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(flight: Flight?): Ticket?{
        return flight?.let {
            ticketDataSource.tickets.first().apply {
                this.flight = flight
            }
        }
    }
}