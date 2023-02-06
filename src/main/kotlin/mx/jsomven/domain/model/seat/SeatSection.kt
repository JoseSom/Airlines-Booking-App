package mx.jsomven.domain.model.seat

import mx.jsomven.domain.model.seat.Seat
import mx.jsomven.domain.model.seat.SeatClass
import java.math.BigDecimal

data class SeatSection(
    val seats: Array<Seat>,
    val price: BigDecimal,
    val seatClass: SeatClass
)
