package com.lp.routes

import com.lp.db.Database
import com.lp.db.PackFactory
import com.lp.model.Lighting
import com.lp.model.Pack
import com.lp.model.Temperature
import com.lp.utils.getTime
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.mustache.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.registerGetRequests() {
    routing {
        getAllPacks()
        getAllPacksJSON()
        getSmth()
    }
}

private fun Route.getAllPacks() {
    get("/packs") {
        val result = pack.getAll()
        if (result.isEmpty()) call.respond(status = HttpStatusCode.NotFound, message = "db table is empty")
        call.respond(MustacheContent("packs.hbs", mapOf("packs" to result)))
    }

    static("static") {
        resources("css")
    }
}

private fun Route.getAllPacksJSON() {
    get("/packsJSON") {
        val result = pack.getAll()
        if (result.isEmpty()) call.respond(status = HttpStatusCode.NotFound, message = "db table is empty")
        call.respond(result)
    }
}

private fun Route.getSmth() {
    get("/") {
        val result = Pack(
            getTime(),
            Temperature(14, "C"),
            Lighting(324, "L")
        )
        call.respond(result)
    }
}


private val pack = PackFactory(Database.packs)