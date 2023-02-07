package mx.jsomven.presentation.menu

import mx.jsomven.domain.presentation.Formatter
import mx.jsomven.presentation.extfunction.isMenuOptionValid
import mx.jsomven.presentation.flight.formats.FlightCosoleFormat

interface UIMenu<T> {
    fun showMenu(
        mapObjects: Map<Int, T>,
        formatter: Formatter<T>
    ): T? {
        var option = ""
        do {
            mapObjects.forEach { (t, u) ->
                print("$t. ")
                println(formatter.format(u))
            }
            println("*** SELECT NUMBER OPTION ***")
            option = readLine().orEmpty()
        }while (!option.isMenuOptionValid(mapObjects))

        return mapObjects[option.toInt()]
    }

}