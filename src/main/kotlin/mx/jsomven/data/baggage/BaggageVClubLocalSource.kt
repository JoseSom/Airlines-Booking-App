package mx.jsomven.data.baggage

import mx.jsomven.domain.model.baggage.pack.BaggagePackage
import mx.jsomven.domain.model.baggage.pack.vclub.ClubBasic
import mx.jsomven.domain.model.baggage.pack.vclub.ClubClassic
import mx.jsomven.domain.model.baggage.pack.vclub.ClubPlus

class BaggageVClubLocalSource : BaggagePackageLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> = mapOf(
        1 to ClubBasic(price),
        2 to ClubClassic(price),
        3 to ClubPlus(price),
    )
}