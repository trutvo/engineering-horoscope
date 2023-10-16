package com.github.engineeringhoroscope.bl.service

import com.github.engineeringhoroscope.bl.model.AstrologicalSign
import com.github.engineeringhoroscope.bl.model.Horoscope
import com.github.engineeringhoroscope.bl.ports.HoroscopeRepository

interface HoroscopeService {
    fun getMonthlyHoroscope(): Any
}

class HoroscopeServiceImpl(private val repository: HoroscopeRepository) : HoroscopeService {
    override fun getMonthlyHoroscope(): Horoscope {
        val shuffledProphecies = repository.getProphecies().shuffled()
        if(shuffledProphecies.size < AstrologicalSign.values().size) {
            throw IllegalStateException("Not enough prophecies for every sign!")
        }
        val prophecyMap = AstrologicalSign.values().zip(shuffledProphecies).toMap()
        return Horoscope(prophecies = prophecyMap)
    }

}