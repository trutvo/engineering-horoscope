package com.github.engineeringhoroscope.bl

import java.time.LocalDate
import java.time.Month

enum class AstrologicalSign(val symbol: Char, val startDay: Int, val startMonth: Month) {
    Aries('♈', 21, Month.MARCH),
    Taurus('♉', 21, Month.APRIL),
    Gemini('♊',22, Month.MAY),
    Cancer('♋',22, Month.JUNE),
    Leo('♌',24, Month.JULY),
    Virgo('♍',24, Month.AUGUST),
    Libra('♎',24, Month.SEPTEMBER),
    Scorpio('♏',24, Month.OCTOBER),
    Sagittarius('♐',23, Month.NOVEMBER),
    Capricorn('♑',22, Month.DECEMBER),
    Aquarius('♒',21, Month.JANUARY),
    Pisces('♓',20, Month.FEBRUARY);

    companion object {
        fun from(birthDate: LocalDate): AstrologicalSign {
            val currentMonth = values().first { it.startMonth == birthDate.month }
            if (birthDate.dayOfMonth >= currentMonth.startDay) return currentMonth
            return currentMonth.predecessor()
        }
    }

    private fun predecessor(): AstrologicalSign {
        return when (val index = ordinal - 1) {
            -1 -> AstrologicalSign.values()[AstrologicalSign.values().size - 1]
            else -> AstrologicalSign.values()[index]
        }
    }
}

