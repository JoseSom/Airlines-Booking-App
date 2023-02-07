package mx.jsomven.data.baggage

import mx.jsomven.domain.datasource.baggage.BaggagePackageDataSource
import mx.jsomven.domain.model.baggage.pack.BaggagePackage
import java.math.BigDecimal

abstract class BaggagePackageLocalSource: BaggagePackageDataSource {
    val price: BigDecimal = BigDecimal(50)
}