package mx.jsomven.domain.datasource.reservation

import mx.jsomven.domain.model.Reservation

interface ReservationDataSource {
    val reservation: Reservation
}