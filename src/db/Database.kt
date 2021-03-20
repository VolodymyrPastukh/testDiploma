package com.lp.db

import com.lp.model.Pack
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object Database {
    private val client = KMongo.createClient("mongodb://database")
    private val database = client.getDatabase("testDiplom")
    val packs = database.getCollection<Pack>()


}
