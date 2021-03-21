package com.lp.db

import com.lp.model.Flame
import com.lp.model.Pack
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object Database {
    private val client = KMongo.createClient()
//    private val client = KMongo.createClient(
//        MongoClientSettings.builder()
//            .applyConnectionString(ConnectionString("mongodb://database"))
//            .credential(
//                MongoCredential.createCredential(
//                    "campus",
//                    "test",
//                    "detitoorki".toCharArray()
//                )
//            )
//            .build()
//    )
    private val database = client.getDatabase("test")
    val packs = database.getCollection<Pack>()
    val flames = database.getCollection<Flame>()


}
