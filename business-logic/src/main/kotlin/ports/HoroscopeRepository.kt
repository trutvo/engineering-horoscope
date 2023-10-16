package com.github.engineeringhoroscope.bl.ports

import com.github.engineeringhoroscope.bl.model.Horoscope
import com.github.engineeringhoroscope.bl.model.Prophecy

interface HoroscopeRepository {
    fun getProphecies(): List<Prophecy>

    fun addProphecy(prophecy: Prophecy)

    fun getHoroscopeHistory(limit: Int = 3): List<Horoscope>

    fun addHoroscope(horoscope: Horoscope)
}