package com.github.engineeringhoroscope.bl.model

import java.time.LocalDate
import java.util.*

data class Horoscope(
        val uuid: String = UUID.randomUUID().toString(),
        val date: LocalDate = LocalDate.now(),
        val prophecies: Map<AstrologicalSign, Prophecy>)