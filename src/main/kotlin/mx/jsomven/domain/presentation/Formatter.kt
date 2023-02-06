package mx.jsomven.domain.presentation

import mx.jsomven.domain.model.Flight
import java.lang.StringBuilder

interface Formatter<T> {
    fun format(t: T): String
    fun format(ts: List<T>): String {
        val stringBuilder = StringBuilder()
        ts.forEach {
            stringBuilder.appendLine(format(it))
        }
        return stringBuilder.toString()
    }
}