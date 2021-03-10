package com.lp.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getTime(): String {
    val current = LocalDateTime.now()
    val format = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")
    return current.format(format)
}