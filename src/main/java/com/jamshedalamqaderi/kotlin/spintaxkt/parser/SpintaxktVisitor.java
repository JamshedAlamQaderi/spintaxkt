// Generated from java-escape by ANTLR 4.11.1
package com.jamshedalamqaderi.kotlin.spintaxkt.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpintaxktParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpintaxktVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SpintaxktParser#spintax}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpintax(SpintaxktParser.SpintaxContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpintaxktParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(SpintaxktParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpintaxktParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(SpintaxktParser.ChoiceContext ctx);
}