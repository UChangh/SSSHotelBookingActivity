package com.example.ssshotelbookingactivity

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    var name: String = "Admin"
    var roomno: Int = 100
    var checkin: String = "1900/01/01"
    var checkout: String = "2100/12/31"

    while (true) {
        print("호텔 예약 프로그램\n1.호텔 예약, 2.예약자 목록, 3.목록 정렬, 4.프로그램 종료, 5.사용자 조회, 6.사용자 변경")
        var menu = input().toInt()

        when(menu) {
            1 -> {
                println("성함을 입력해 주세요")
                name = input()
                println("예약하실 방 번호를 입력해 주세요")
                roomno = input().toInt()

                roomno = roomno(roomno)

                println("체크인 날짜를 입력해 주세요. 형식 : yyyy/MM/dd")
                checkin = input()
                println("체크아웃 날짜를 입력해 주세요. 형식 : yyyy/MM/dd")
                checkout = input()

                checkin = check(checkin)
                checkout = check(checkout)

                check(checkin,checkout)

                BookingFlow(name, roomno, checkin, checkout)
            }
            2 -> {}
            3 -> {}
            4 -> {
                println("프로그램 종료")
                break
            }
            5 -> {}
            6 -> {}
            else -> {
                println("다시 입력해 주세요")
                continue
            }
        }
    }
}

fun input() = readln()

fun roomno(room:Int):Int {
    var room = room
    var roomlist = mutableListOf<Int>()                 // roomno를 추출, 다음 손님이 room을 예약할 때 이미 지정된 Room은 빼기
    for(i in 0..899) {
        roomlist.add(i+100)
    }
    var booklist = mutableListOf<Int>()                     // 이미 예약된 방, 예약 취소 or 종료 => roomlist에 추가

    while(true) {
        when {
            room in roomlist -> {
                println("선택하신 방은 예약이 가능합니다.")
                break
            }
            room in booklist -> {
                println("선택하신 방은 예약이 불가능합니다.")
                println("다른 방을 입력해 주세요.")
                room = input().toInt()
                continue
            }
        }
    }
    return room
}
fun today(): String {
    var today = LocalDate.now()
    var dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    return today.format(dateFormat)
}
fun check(chkin:String, chkout:String):String {
    var chkin = chkin
    var chkout = chkout
    while(true) {
        when {
            chkin < today() -> {
                println("오늘 날짜보다 이전 날짜는 선택하실 수 없습니다.")
                println("날짜를 다시 입력해 주세요.")
                chkin = CheckDate().check(input())
            }
            chkin.isNotEmpty() && chkin > chkout -> {
                println("체크인 날짜보다 이전 날짜는 선택하실 수 없습니다.")
                println("날짜를 다시 입력해 주세요.")
                chkout = CheckDate().check(input())
            }
            chkin > today() && chkout > chkin -> {
                println("체크인 날짜를 선택하셨습니다.")
                return chkin
            }
        }
    }
}