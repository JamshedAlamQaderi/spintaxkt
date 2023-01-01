package com.jamshedalamqaderi.spintaxkt.visitors

import com.jamshedalamqaderi.spintaxkt.parser.SpintaxktBaseVisitor
import com.jamshedalamqaderi.spintaxkt.parser.SpintaxktParser

class SpintaxktVariationCounter : SpintaxktBaseVisitor<Unit>() {
    var variations = 1
        private set

    override fun visitChoice(ctx: SpintaxktParser.ChoiceContext?) {
        variations *= (ctx?.element()?.size ?: 1)
    }
}
