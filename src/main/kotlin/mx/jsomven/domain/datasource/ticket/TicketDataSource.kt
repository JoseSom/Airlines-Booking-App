package mx.jsomven.domain.datasource.ticket

import mx.jsomven.domain.model.Ticket

interface TicketDataSource {
    val tickets: List<Ticket>
}