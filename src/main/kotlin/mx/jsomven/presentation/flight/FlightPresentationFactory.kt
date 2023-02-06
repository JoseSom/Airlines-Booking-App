package mx.jsomven.presentation.flight

import mx.jsomven.domain.model.Flight
import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.presentation.PresentationFactory
import mx.jsomven.presentation.PresentationFormat
import mx.jsomven.presentation.flight.formats.FlightCosoleFormat
import mx.jsomven.presentation.flight.formats.FlightHTMLFormat

class FlightPresentationFactory : PresentationFactory<Flight>{
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Flight>{
        return when(format){
            PresentationFormat.CONSOLE -> FlightCosoleFormat()
            PresentationFormat.HTML -> FlightHTMLFormat()
            else -> FlightCosoleFormat()
        }
    }

}