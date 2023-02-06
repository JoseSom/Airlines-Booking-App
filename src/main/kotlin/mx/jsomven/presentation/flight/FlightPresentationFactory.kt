package mx.jsomven.presentation.flight

import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.presentation.PresentationFormat

class FlightPresentationFactory {
    fun getPresentationFormat(format: PresentationFormat): Formatter<Flight>{
        return when(format){
            PresentationFormat.CONSOLE -> FlightCosoleFormat()
            PresentationFormat.HTML -> FlightHTMLFormat()
            else -> FlightCosoleFormat()
        }
    }
}