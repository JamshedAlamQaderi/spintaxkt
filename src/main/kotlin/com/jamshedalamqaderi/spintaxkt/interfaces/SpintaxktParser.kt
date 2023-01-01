package com.jamshedalamqaderi.spintaxkt.interfaces

interface SpintaxktParser {
    fun sentence(): String
    fun sentences(): List<String>
    fun variations(): Int
}
