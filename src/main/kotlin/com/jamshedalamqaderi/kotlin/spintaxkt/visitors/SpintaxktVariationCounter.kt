package com.jamshedalamqaderi.kotlin.spintaxkt.visitors

import com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktBaseVisitor
import com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktParser

class SpintaxktVariationCounter : SpintaxktBaseVisitor<Unit>() {
    var variations = 1
        private set

    override fun visitChoice(ctx: SpintaxktParser.ChoiceContext?) {
        variations *= (ctx?.element()?.size ?: 1)
    }
}