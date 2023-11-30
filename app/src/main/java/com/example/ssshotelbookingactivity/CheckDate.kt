package com.example.ssshotelbookingactivity

import java.time.LocalDate
import java.time.format.DateTimeFormatter

open class CheckDate {
    open fun check(date:String):String {
        var chk = date.split("/")
        var dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd")  // string type
        var check = LocalDate.of(chk[0].toInt(), chk[1].toInt(), chk[2].toInt())

        println("체크인 날짜 : ${check.format(dateFormat)}")
        return check.format(dateFormat)
    }
}