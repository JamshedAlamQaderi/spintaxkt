package com.jamshedalamqaderi.spintaxkt

import com.jamshedalamqaderi.spintaxkt.impl.SpintaxktParserImpl
import com.jamshedalamqaderi.spintaxkt.interfaces.SpintaxktParser

object SpintaxktUtils {
    fun String.parser(): SpintaxktParser {
        return SpintaxktParserImpl(this@parser)
    }
}
