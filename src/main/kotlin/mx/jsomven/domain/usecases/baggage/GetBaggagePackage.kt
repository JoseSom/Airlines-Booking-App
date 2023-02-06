package mx.jsomven.domain.usecases.baggage

import mx.jsomven.domain.model.baggage.pack.BaggagePackage

/*
* Mostrar los tipos de Equipajes disponibles
* */
class GetBaggagePackage {
    operator fun invoke(): Map<Int, BaggagePackage>{
        return mapOf()
    }
}