package mx.jsomven.presentation.baggage.types

import mx.jsomven.domain.model.baggage.type.BaggageType
import mx.jsomven.domain.presentation.Formatter

class BaggageTypesConsole : Formatter<BaggageType> {
    override fun format(t: BaggageType): String {
        return """
            ${t.emoji} ${t.quantity} ${t.title}
        """.trimIndent()
    }
}