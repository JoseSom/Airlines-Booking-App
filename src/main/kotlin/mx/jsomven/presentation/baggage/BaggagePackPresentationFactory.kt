package mx.jsomven.presentation.baggage

import mx.jsomven.domain.model.baggage.pack.BaggagePackage
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.presentation.PresentationFactory
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.baggage.format.BaggagePackageConsoleFormat
import mx.jsomven.presentation.baggage.types.BaggageTypesConsole

class BaggagePackPresentationFactory : PresentationFactory<BaggagePackage> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<BaggagePackage> {
        return BaggagePackageConsoleFormat(
            BaggageTypesConsole()
        )
    }
}