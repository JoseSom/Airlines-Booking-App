package mx.jsomven.domain.datasource.baggage

import mx.jsomven.domain.model.baggage.pack.BaggagePackage

interface BaggagePackageDataSource {
    fun getBaggagePacks(): Map<Int, BaggagePackage>
}