package mx.jsomven.domain.model.baggage.pack.vclub

import mx.jsomven.domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubPlus(
    price: BigDecimal
) : VClub(price) {

    override val name: String = "Plus"
    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD

}