package com.github.engineeringhoroscope.bl

import com.github.engineeringhoroscope.bl.model.Horoscope
import com.github.engineeringhoroscope.bl.model.Prophecy
import com.github.engineeringhoroscope.bl.ports.HoroscopeRepository
import org.junit.jupiter.api.Test
import service.HoroscopeServiceImpl

class TestHoroscopeRepository(
        private var horoscopes: List<Horoscope> = ArrayList(),
        private var prophecies: List<Prophecy> = ArrayList()
): HoroscopeRepository {
    override fun getProphecies(): List<Prophecy> {
        return prophecies // return the reference - it is immutable as long as we in the kotlin world
    }

    override fun addProphecy(prophecy: Prophecy) {
        prophecies = prophecies + prophecy
    }

    override fun getHoroscopeHistory(limit: Int): List<Horoscope> {
        return horoscopes.takeLast(limit) // nice helper here
    }

    override fun addHoroscope(horoscope: Horoscope) {
        horoscopes = horoscopes + horoscope;
    }

}

class HoroscopeServiceTest {
    @Test
    public fun testHoroscopeCreation() {
        val repository = TestHoroscopeRepository()
        for (i in 1..24) {
            repository.addProphecy(Prophecy(text = "prophecy $i"))
        }
        val horoscopeService = HoroscopeServiceImpl(repository)
        val horoscope = horoscopeService.getMonthlyHoroscope()
        assert(horoscope != null)
    }
}