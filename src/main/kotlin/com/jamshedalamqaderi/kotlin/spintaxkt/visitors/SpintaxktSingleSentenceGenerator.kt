package com.jamshedalamqaderi.kotlin.spintaxkt.visitors

import com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktBaseVisitor
import com.jamshedalamqaderi.kotlin.spintaxkt.parser.SpintaxktParser
import org.antlr.v4.runtime.tree.TerminalNode
import kotlin.random.Random

class SpintaxktSingleSentenceGenerator : SpintaxktBaseVisitor<Unit>() {
    private val builder = StringBuilder()
    var sentence: String = ""
        private set
        get() = builder.toString()

    override fun visitElement(ctx: SpintaxktParser.ElementContext) {
        if (ctx.choice() != null) {
            return visit(ctx.choice())
        }
        return visitTerminal(ctx.TEXT())
    }

    override fun visitChoice(ctx: SpintaxktParser.ChoiceContext) {
        val element = ctx.element()
        if (element.isEmpty()) return
        val choice = element[Random.nextInt(element.size)]
        return visitElement(choice)
    }

    override fun visitTerminal(node: TerminalNode?) {
        builder.append(node?.text)
    }
}
