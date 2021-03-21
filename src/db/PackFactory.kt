package com.lp.db

import com.lp.model.Pack
import com.lp.utils.getTime
import com.mongodb.client.MongoCollection

class PackFactory(private val db: MongoCollection<Pack>) {
    fun getAll() = db.find().toList()

    fun putOne(pack: Pack){
        val result = Pack(
            getTime(),
            pack.temperature,
            pack.light
        )
        db.insertOne(result)
    }
}