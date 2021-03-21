package com.lp.utils

import java.time.format.DateTimeFormatter
import java.time.ZonedDateTime
import java.time.ZoneId


fun getTime(): String {
    val zone = ZoneId.of("Europe/Kiev")
    val current = ZonedDateTime.now(zone)
    val format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
    return current.format(format)
}
