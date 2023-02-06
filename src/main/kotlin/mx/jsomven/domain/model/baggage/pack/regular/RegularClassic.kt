package mx.jsomven.domain.model.baggage.pack.regular

import mx.jsomven.domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularClassic(
    price: BigDecimal
) : Regular(price) {
    override val name: String = "Classic"
    override val boardingTurn: BoardingTurn = BoardingTurn.END
}