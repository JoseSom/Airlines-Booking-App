package mx.jsomven.presentation

import mx.jsomven.domain.presentation.Formatter

interface PresentationFactory<T> {
    fun getPresentationFormat(format: PresentationFormat) : Formatter<T>
}