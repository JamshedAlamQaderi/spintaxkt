package com.jamshedalamqaderi.kotlin.spintaxkt.visitors


import com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktBaseVisitor
import com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktParser
import org.antlr.v4.runtime.tree.TerminalNode

class SpintaxktAllSentenceGenerator : SpintaxktBaseVisitor<Unit>() {
    val sentences = arrayListOf<String>()

    override fun visitChoice(ctx: SpintaxktParser.ChoiceContext) {
        val tempSentences = sentences.map { it }
        sentences.clear()
        ctx.element().forEach { elementContext ->
            if (elementContext.choice() == null) {
                if (tempSentences.isNotEmpty()) {
                    tempSentences.forEach { cacheSentence ->
                        sentences.add(cacheSentence + elementContext.text)
                    }
                } else {
                    sentences.add(elementContext.text)
                }
            }
        }
    }

    override fun visitElement(ctx: SpintaxktParser.ElementContext) {
        if (ctx.choice() != null) {
            return visit(ctx.choice())
        }
        visitTerminal(ctx.TEXT())
    }

    override fun visitTerminal(node: TerminalNode) {
        if (sentences.isEmpty()) {
            sentences.add(node.text)
        } else {
            val tempSentences = sentences.map { it }
            sentences.clear()
            sentences.addAll(tempSentences.map { it + node.text })
        }
    }
}