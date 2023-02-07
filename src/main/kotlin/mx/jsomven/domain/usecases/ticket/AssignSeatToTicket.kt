package mx.jsomven.domain.usecases.ticket

import mx.jsomven.domain.datasource.ticket.TicketDataSource
import mx.jsomven.domain.model.Ticket
import mx.jsomven.domain.model.seat.Seat

/**
 * Asignar asiento a un ticket
 */
class AssignSeatToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(seat: Seat?): Ticket? {
        return seat?.let {
            ticketDataSource.tickets.first().apply {
                this.seat = it
            }
        }
    }
}