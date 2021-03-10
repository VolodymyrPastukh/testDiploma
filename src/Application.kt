package com.lp

import io.ktor.application.*
import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.mustache.Mustache
import com.lp.routes.registerGetRequests
import com.lp.routes.registerPostRequests
import io.ktor.features.*
import io.ktor.serialization.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates/mustache")
    }

    install(ContentNegotiation) {
        json()
    }
    registerGetRequests()
    registerPostRequests()
}


