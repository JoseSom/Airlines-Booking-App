package mx.jsomven.domain.model.baggage.pack.vclub

import mx.jsomven.domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubClassic(
    price: BigDecimal
) : VClub(price) {

    override val name: String = "Classic"
    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD

    override var price: BigDecimal = price
        get() {
            return super.price + BigDecimal(10)
        }
}