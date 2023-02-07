package mx.jsomven.domain.usecases.reservation

import mx.jsomven.domain.datasource.reservation.ReservationDataSource
import mx.jsomven.domain.model.Reservation
import mx.jsomven.domain.model.Ticket

/**
 *
 */

private const val CODE_SIZE = 5

class AssignTicketToReservation(
    private val reservationDataSource: ReservationDataSource
) {
    operator fun invoke(ticket: List<Ticket>): Reservation {
        return reservationDataSource.reservation.apply {
            this.code = generateCode()
            this.departureTickets = ticket
            this.returnTickets = ticket
        }
    }

    private fun generateCode(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..CODE_SIZE).map {
            allowedChars.random()
        }.joinToString("")
    }
}