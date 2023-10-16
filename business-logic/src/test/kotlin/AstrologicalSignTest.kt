package com.github.engineeringhoroscope.bl

import com.github.engineeringhoroscope.bl.model.AstrologicalSign
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month

class AstrologicalSignTest {

    @Test
    fun testAttributes() {
        assertEquals("Aries", AstrologicalSign.Aries.name)
        assertEquals('♈', AstrologicalSign.Aries.symbol)
        assertEquals(21, AstrologicalSign.Aries.startDay)
        assertEquals(Month.MARCH, AstrologicalSign.Aries.startMonth)
    }

    @Test
    fun `test from()`() {
        assertEquals(AstrologicalSign.Aries, AstrologicalSign.from(LocalDate.of(2020, Month.MARCH, 21)))
        assertEquals(AstrologicalSign.Capricorn, AstrologicalSign.from(LocalDate.of(2000, Month.DECEMBER, 30)))
        assertEquals(AstrologicalSign.Sagittarius, AstrologicalSign.from(LocalDate.of(2000, Month.DECEMBER, 10)))
    }

    @Test
    fun `test from() overflow`() {
        assertEquals(AstrologicalSign.Pisces, AstrologicalSign.from(LocalDate.of(1980, Month.MARCH, 20)))
    }
    @Test
    fun `test from() for Albert Einstein`() {
        assertEquals(AstrologicalSign.Pisces, AstrologicalSign.from(LocalDate.of(1879, Month.MARCH, 14)))
    }

    @Test
    fun `test from() for Marie Curie`() {
        assertEquals(AstrologicalSign.Scorpio, AstrologicalSign.from(LocalDate.of(1867, Month.NOVEMBER, 7)))
    }

    @Test
    fun `test from() for Frank Elstner`() {
        assertEquals(AstrologicalSign.Aries, AstrologicalSign.from(LocalDate.of(1942, Month.APRIL, 19)))
    }
}