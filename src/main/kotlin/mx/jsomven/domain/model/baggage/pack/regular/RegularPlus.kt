package mx.jsomven.domain.model.baggage.pack.regular

import mx.jsomven.domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularPlus(
    price: BigDecimal
) : Regular(price) {
    override val name: String = "Plus"
    override val boardingTurn: BoardingTurn = BoardingTurn.END
    override var price: BigDecimal = price + BigDecimal(20)
}