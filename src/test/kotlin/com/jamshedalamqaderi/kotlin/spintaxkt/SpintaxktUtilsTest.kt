package com.jamshedalamqaderi.kotlin.spintaxkt

import com.jamshedalamqaderi.kotlin.spintaxkt.SpintaxktUtils.parser
import kotlin.test.assertContains
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class SpintaxktUtilsTest {
    @Test
    fun testParser() {
        // Test with a simple spintax string
        val spintax = "{Hello|Hi} {world|there}"
        val parser = spintax.parser()
        val sentences = parser.sentences()
        assertEquals(listOf("Hello world", "Hi world", "Hello there", "Hi there"), sentences)
        assertContains(
            listOf("Hello world", "Hi world", "Hello there", "Hi there"),
            parser.sentence()
        )

        // Test with a more complex spintax string
        val spintax2 = "Hello, {my|your} {name|friend} is {John|Mike|Sarah}"
        val parser2 = spintax2.parser()
        val sentences2 = parser2.sentences()
        assertEquals(12, sentences2.size)
        assertEquals(12, parser2.variations())
    }

}