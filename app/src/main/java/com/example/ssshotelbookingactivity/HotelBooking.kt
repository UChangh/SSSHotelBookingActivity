package com.example.ssshotelbookingactivity

import kotlin.random.Random

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

data class Person (
    var name:String,
    var roomno: Int,
    var checkin: String,
    var checkout: String
)

var lists = Room.rooms(0).toList()
var roomlists = lists[0]
var booklists = lists[1]

var list = HashMap<Int, Array<Any>>()

var moneyrange = Random.nextInt(10000,50001)

fun main() {
    while (true) {
        try {
            print("호텔 예약 프로그램\n1.호텔 예약, 2.예약자 목록, 3.목록 정렬, 4.프로그램 종료, 5.사용자 조회, 6.사용자 변경")
            var menu = readln().toInt()
            when (menu) {
                1 -> {
                    println("${menu}. 호텔 예약")
                    Menu1().menu1()
                }
                2 -> {
                    println("${menu}. 예약자 목록")
                    Menu2().show()
                }
                3 -> {
                    println("${menu}. 목록 정렬")
                    Menu3().sort()
                }
                4 -> {
                    println("${menu}. 프로그램 종료")
                    break
                }
                5 -> {
                    println("${menu}. 사용자 조회")
                }
                6 -> {
                    println("${menu}. 사용자 이름 변경")
                }
                else -> {
                    println("다시 입력해 주세요")
                    continue
                }
            }
        } catch (e:Exception) {
            println("e: $e\n다시 입력해주세요.")
        }
    }
}