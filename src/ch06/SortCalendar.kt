package ch06

import java.util.*

fun main() {
    val x = arrayOf(
        GregorianCalendar(2022, GregorianCalendar.NOVEMBER, 1),    // 2022년 11월 1일
        GregorianCalendar(1963, GregorianCalendar.OCTOBER, 18),    // 1963년 10월 18일
        GregorianCalendar(1985, GregorianCalendar.APRIL, 5)        // 1985년 4월 5일
    )

    x.sort()

    for (i in 0 until x.size) {
        println(
            "%04d년 %02d월 %02d일".format(
                x[i].get(GregorianCalendar.YEAR),
                x[i].get(GregorianCalendar.MONTH) + 1,
                x[i].get(GregorianCalendar.DATE)
            )
        )
    }
}