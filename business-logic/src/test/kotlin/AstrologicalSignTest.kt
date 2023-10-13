package com.github.engineeringhoroscope.bl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month

class AstrologicalSignTest {
    @Test
    fun `test from()`() {
        assertEquals(AstrologicalSign.Aries, AstrologicalSign.from(LocalDate.of(2020, Month.MARCH, 21)))
        assertEquals(AstrologicalSign.Capricorn, AstrologicalSign.from(LocalDate.of(2000, Month.DECEMBER, 30)))
        assertEquals(AstrologicalSign.Sagittarius, AstrologicalSign.from(LocalDate.of(2000, Month.DECEMBER, 10)))
        assertEquals(AstrologicalSign.Aries, AstrologicalSign.from(LocalDate.of(1973, Month.APRIL, 19)))
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
}