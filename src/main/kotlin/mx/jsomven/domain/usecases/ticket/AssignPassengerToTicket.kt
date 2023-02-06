package mx.jsomven.domain.usecases.ticket

import mx.jsomven.domain.model.Passenger
import mx.jsomven.domain.model.Ticket

/**
 * Introducir Informacion del pasajero
 */
class AssignPassengerToTicket {
    operator fun invoke(passenger: Passenger) /*:Ticket*/ {}
}