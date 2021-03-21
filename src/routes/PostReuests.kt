package com.lp.routes

import com.lp.db.Database
import com.lp.db.FlameFactory
import com.lp.db.PackFactory
import com.lp.model.Flame
import com.lp.model.Pack
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.registerPostRequests() {
    routing {
        postPack()
        postFlame()
    }
}

private fun Route.postPack() {
    post("/packs") {
        val template = call.receive<Pack>()
        pack.putOne(template)
        call.respondText("Temp and Light stored correctly", status = HttpStatusCode.Accepted)
    }
}

private fun Route.postFlame() {
    post("/flame") {
        flame.putOne()
        call.respondText("FLame stored correctly", status = HttpStatusCode.Accepted)
    }
}

private val pack = PackFactory(Database.packs)
private val flame = FlameFactory(Database.flames)