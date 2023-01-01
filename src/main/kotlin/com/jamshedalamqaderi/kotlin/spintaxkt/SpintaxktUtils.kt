package com.jamshedalamqaderi.kotlin.spintaxkt

import com.jamshedalamqaderi.kotlin.spintaxkt.impl.SpintaxktParserImpl
import com.jamshedalamqaderi.kotlin.spintaxkt.interfaces.SpintaxktParser

object SpintaxktUtils {
    fun String.parser(): SpintaxktParser {
        return SpintaxktParserImpl(this@parser)
    }
}
