package mx.jsomven.domain.usecases.baggage

import mx.jsomven.domain.datasource.ticket.TicketDataSource
import mx.jsomven.domain.model.baggage.pack.BaggagePackage

class GetBaggageSaved(
    private val ticketsDataSource: TicketDataSource
) {
    operator fun invoke(): BaggagePackage {
        return ticketsDataSource.tickets.first().baggagePackage
    }
}