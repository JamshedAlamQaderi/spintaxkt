package com.jamshedalamqaderi.kotlin.spintaxkt.impl

import com.jamshedalamqaderi.kotlin.spintaxkt.interfaces.SpintaxktParser
import com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktLexer
import com.jamshedalamqaderi.kotlin.spintaxkt.visitors.SpintaxktAllSentenceGenerator
import com.jamshedalamqaderi.kotlin.spintaxkt.visitors.SpintaxktSingleSentenceGenerator
import com.jamshedalamqaderi.kotlin.spintaxkt.visitors.SpintaxktVariationCounter
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class SpintaxktParserImpl(spintax: String) : SpintaxktParser {
    private val sentenceGenerator = SpintaxktSingleSentenceGenerator()
    private val variationCounter = SpintaxktVariationCounter()
    private val allSentenceGenerator = SpintaxktAllSentenceGenerator()

    private var cachedVariations = -1

    private val spintaxCtx = com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktParser(
        CommonTokenStream(
            SpintaxktLexer(
                CharStreams.fromString(spintax)
            )
        )
    ).spintax()

    override fun sentence(): String {
        spintaxCtx.accept(sentenceGenerator)
        return sentenceGenerator.sentence
    }

    override fun sentences(): List<String> {
        spintaxCtx.accept(allSentenceGenerator)
        return allSentenceGenerator.sentences
    }

    override fun variations(): Int {
        if (cachedVariations == -1) {
            spintaxCtx.accept(variationCounter)
            cachedVariations = variationCounter.variations
        }
        return cachedVariations
    }
}
