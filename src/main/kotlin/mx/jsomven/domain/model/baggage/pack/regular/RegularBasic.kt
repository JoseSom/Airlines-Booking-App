package mx.jsomven.domain.model.baggage.pack.regular

import mx.jsomven.domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularBasic(
    price: BigDecimal
) : Regular(price) {
    override val name: String = "Basic"
    override val boardingTurn: BoardingTurn = BoardingTurn.END

}