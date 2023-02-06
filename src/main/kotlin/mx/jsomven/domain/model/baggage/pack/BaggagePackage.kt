package mx.jsomven.domain.model.baggage.pack

import mx.jsomven.domain.model.baggage.type.BaggageType
import mx.jsomven.domain.model.baggage.type.BigHand
import mx.jsomven.domain.model.baggage.type.Checked
import mx.jsomven.domain.model.baggage.type.Hand
import java.math.BigDecimal

abstract class BaggagePackage() {
    abstract val name: String
    abstract var price: BigDecimal
    abstract val boardingTurn: BoardingTurn

    open val baggageTypes: List<BaggageType> = listOf(
        Hand(),
        BigHand(),
        Checked()
    )

}