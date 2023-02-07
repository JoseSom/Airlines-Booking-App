package mx.jsomven.domain.usecases.baggage

import mx.jsomven.domain.datasource.baggage.BaggagePackageDataSource
import mx.jsomven.domain.model.baggage.pack.BaggagePackage

/*
* Mostrar los tipos de Equipajes disponibles
* */
class GetBaggagePackage(
    private val baggagePackageDataSource: BaggagePackageDataSource
) {
    operator fun invoke(): Map<Int, BaggagePackage>{
        return baggagePackageDataSource.getBaggagePacks()
    }
}