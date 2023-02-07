package mx.jsomven.presentation.baggage.format

import mx.jsomven.domain.model.baggage.pack.BaggagePackage
import mx.jsomven.domain.model.baggage.type.BaggageType
import mx.jsomven.domain.presentation.Formatter

class BaggagePackageConsoleFormat(
    private val baggageType: Formatter<BaggageType>
) : Formatter<BaggagePackage> {
    override fun format(t: BaggagePackage): String {
        return """
${t.name}
${baggageType.format(t.baggageTypes).trim()}
Boarding Turn: ${t.boardingTurn.name}
Price: $${t.price}
        """.trimIndent()
    }
}