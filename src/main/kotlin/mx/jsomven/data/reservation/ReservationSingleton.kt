package mx.jsomven.data.reservation

import mx.jsomven.domain.datasource.reservation.ReservationDataSource
import mx.jsomven.domain.model.Reservation

class ReservationSingleton: ReservationDataSource {

    companion object{
        private val reservation = Reservation()
    }
    override val reservation: Reservation = ReservationSingleton.reservation
}