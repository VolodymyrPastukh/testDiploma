package com.lp.model

import kotlinx.serialization.Serializable

@Serializable
data class Temperature(val value: Int, val measure: String)

@Serializable
data class Light(val value: Int, val measure: String)

@Serializable
data class Flame(val time: String?, val state: Boolean)

@Serializable
data class Pack(
    val time: String?,
    val temperature: Temperature,
    val light: Light
)

