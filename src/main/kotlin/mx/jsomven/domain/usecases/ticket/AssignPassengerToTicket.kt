package mx.jsomven.domain.usecases.ticket

import mx.jsomven.domain.datasource.ticket.TicketDataSource
import mx.jsomven.domain.model.Passenger
import mx.jsomven.domain.model.Ticket

/**
 * Introducir Informacion del pasajero
 */
class AssignPassengerToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(passenger: Passenger):Ticket {
        return ticketDataSource.tickets.first().apply {
            this.passenger = passenger
        }
    }
}