package mx.jsomven.domain.usecases.ticket

import mx.jsomven.domain.datasource.ticket.TicketDataSource
import mx.jsomven.domain.model.Ticket
import mx.jsomven.domain.model.baggage.pack.BaggagePackage

/**
 * Seleccionar un equipaje
 */
class AsiggBaggagePackToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(baggagePackage: BaggagePackage?): Ticket? {
        return baggagePackage?.let {
            ticketDataSource.tickets.first().apply {
                this.baggagePackage = it
            }
        }
    }
}