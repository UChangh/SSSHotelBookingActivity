package com.example.ssshotelbookingactivity

import java.time.LocalDate
import java.time.format.DateTimeFormatter

open class CheckDate {
    open fun check(date:String):String {
        var chk = date.split(" ","/")
        var dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd")  // string type
        var check = LocalDate.of(chk[0].toInt(), chk[1].toInt(), chk[2].toInt())
        return check.format(dateFormat)
    }
}

fun today(): String {
    var today = LocalDate.now()
    var dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    return today.format(dateFormat)
}

fun checkin(chkin:String):String {
    var chkin = chkin
    while(true) {
        when {
            chkin < today() -> {
                println("오늘 날짜보다 이전 날짜는 선택하실 수 없습니다.")
                println("날짜를 다시 입력해 주세요.")
                chkin = CheckDate().check(readln())
            }
            chkin >= today() -> {
                println("체크인 날짜를 선택하셨습니다.")
                return chkin
                break
            }
        }
    }
}
fun checkout(chkin:String, chkout:String):String {
    var chkout = chkout
    while(true) {
        when {
            chkin > chkout -> {
                println("체크인 날짜보다 이전 날짜는 선택하실 수 없습니다.")
                println("날짜를 다시 입력해 주세요.")
                chkout = CheckDate().check(readln())
            }
            chkout > chkin -> {
                println("체크아웃 날짜를 선택하셨습니다.")
                return chkout
                break
            }
        }
    }
}