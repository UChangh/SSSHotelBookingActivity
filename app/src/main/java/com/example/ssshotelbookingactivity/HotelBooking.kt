package com.example.ssshotelbookingactivity

object Room{
    fun rooms(room:Int?):Pair<MutableList<Int>,MutableList<Int>> {
        var roomlist = mutableListOf<Int>()
        for (i in 100..999) {
            roomlist.add(i)
        }
        var booklist = mutableListOf<Int>()
        return Pair(roomlist, booklist)
    }
}

var lists = Room.rooms(0).toList()
var roomlists = lists[0]
var booklists = lists[1]

fun main() {
    while (true) {
        try {
            print("호텔 예약 프로그램\n1.호텔 예약, 2.예약자 목록, 3.목록 정렬, 4.프로그램 종료, 5.사용자 조회, 6.사용자 변경")
            var menu = readln().toInt()
            when (menu) {
                1 -> {
                    Menu1().menu1()
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
        } catch (e:Exception) {
            println("다시 입력해주세요.")
        }
    }
}

open class PeopleList {
    var list = mutableListOf<Book>()
}
