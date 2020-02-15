package com.rs.intercom.helpers

import java.util.logging.Level
import java.util.logging.Logger

internal object Logger {

    private const val LOGGER_NAME = "Intercom"
    private fun getLogger(name: String) = Logger.getLogger("$LOGGER_NAME $name")

    fun logD(tag: String, message: String) {
        getLogger(tag).log(Level.INFO, message)
    }

    fun logE(tag: String, message: String) {
        getLogger(tag).log(Level.SEVERE, message)
    }
}