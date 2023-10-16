package service

import com.github.engineeringhoroscope.bl.model.AstrologicalSign
import com.github.engineeringhoroscope.bl.model.Horoscope
import com.github.engineeringhoroscope.bl.ports.HoroscopeRepository

interface HoroscopeService {
    fun getMonthlyHoroscope(): Any
}

class HoroscopeServiceImpl(val repository: HoroscopeRepository) : HoroscopeService {
    override fun getMonthlyHoroscope(): Horoscope {
        val shuffledProphecies = repository.getProphecies().shuffled()
        val prophecyMap = AstrologicalSign.values().zip(shuffledProphecies).toMap()
        return Horoscope(prophecies = prophecyMap)
    }

}