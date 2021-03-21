package com.lp.db

import com.lp.model.Flame
import com.lp.utils.getTime
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne

class FlameFactory(private val db: MongoCollection<Flame>) {
    fun getAll() = db.find().toList()

    fun putOne(){
        val time = getTime()
        val result = Flame(
            time = time,
            state = true
        )
        if(db.findOne(Flame::time eq time) == null) db.insertOne(result)
    }
}