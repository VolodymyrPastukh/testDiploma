package com.lp.model

import kotlinx.serialization.Serializable

@Serializable
data class Temperature(val value: Int, val measure: String)

@Serializable
data class Lighting(val value: Int, val measure: String)

@Serializable
data class Led(val id: Int, val state: Boolean)

@Serializable
data class Pack(
    val time: String?,
    val temperature: Temperature,
    val lighting: Lighting
)

