import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("org.jetbrains.dokka") version "1.7.20"
    id("com.vanniktech.maven.publish") version "0.22.0"
    antlr
}

group = "com.jamshedalamqaderi.spintaxkt"
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

mavenPublishing {
    pom {
        name.set("Spintaxkt")
        description.set("Spintaxkt is a Kotlin library for parsing spintax strings and generating all possible combinations of sentences.")
        inceptionYear.set("2023")
        url.set("https://github.com/JamshedAlamQaderi/spintaxkt")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("JamshedAlamQaderi")
                name.set("Jamshed Alam Qaderi")
                url.set("https://github.com/JamshedAlamQaderi")
            }
        }
        scm {
            url.set("https://github.com/JamshedAlamQaderi/spintaxkt")
            connection.set("scm:git:git://github.com/JamshedAlamQaderi/spintaxkt.git")
            developerConnection.set("scm:git:ssh://git@github.com/JamshedAlamQaderi/spintaxkt.git")
        }
    }
    signAllPublications()
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01, true)
}
