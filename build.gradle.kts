import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("org.jetbrains.dokka") version "1.7.20"
    id("com.vanniktech.maven.publish") version "0.22.0"
    antlr
}

group = "com.jamshedalamqaderi.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.11.1")
    testImplementation(kotlin("test"))
}

tasks.generateGrammarSource {
    enabled = false
    outputDirectory = file("src/main/java/com/jamshedalamqaderi/kotlin/spintaxkt/parser/")
    arguments = arguments + listOf(
        "-package",
        "com.jamshedalamqaderi.kotlin.spintaxkt.parser",
        "-visitor",
        "-no-listener"
    )
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}