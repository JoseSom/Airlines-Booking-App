package mx.jsomven.presentation.ticket

import mx.jsomven.domain.model.Ticket
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.presentation.PresentationFactory
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.ticket.formats.TicketConsoleFormat

class TicketPresentationFactory: PresentationFactory<Ticket> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Ticket> {
        return TicketConsoleFormat()
    }
}