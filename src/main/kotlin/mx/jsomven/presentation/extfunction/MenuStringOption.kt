package mx.jsomven.presentation.extfunction

import mx.jsomven.domain.model.Flight
import java.util.EventObject

fun String.isNotBlankOrEmpty(): Boolean = this.isNotEmpty() || this.isNotBlank()
fun String.isNumber(): Boolean = this.all { it.isDigit() }

fun <T> String.isMenuOptionValid(mapObjects: Map<Int, T>): Boolean {
    return if (isNotBlankOrEmpty() && isNumber()) mapObjects.containsKey(this.toInt()) else false
}