package com.example.ssshotelbookingactivity

class Menu2{
    fun show() {
        for((key, value) in list) {
            println("${key+1}. 사용자 : ${value[0]}, 방 번호 : ${value[1]}, 체크인 날짜 : ${value[2]}, 체크아웃 날짜 : ${value[3]}")
        }
    }
}