package mx.jsomven.data.ticket

import mx.jsomven.domain.datasource.ticket.TicketDataSource
import mx.jsomven.domain.model.Ticket

class TicketListSingleton: TicketDataSource{

    companion object{
        private val tickets = mutableListOf(
            Ticket()
        )
    }
    override val tickets: List<Ticket> = TicketListSingleton.tickets
}