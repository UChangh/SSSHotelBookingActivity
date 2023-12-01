package com.example.ssshotelbookingactivity

open class Menu1 {


    open fun menu1(name:String, roomno:Int, checkin:String, checkout:String) {
        var name = name
        var roomno = roomno
        var checkin = checkin
        var checkout = checkout

        println("성함을 입력해 주세요")
        name = input()
        println("예약하실 방 번호를 입력해 주세요")
        roomno = input().toInt()

        roomno = roomno(roomno)

        println("체크인 날짜를 입력해 주세요. 형식 : yyyy/MM/dd")
        checkin = input()
        checkin = checkin(checkin)  // 만약 checkin이 처음에 return하지 못했을 경우(값이 수정되었을 경우)

        println("체크아웃 날짜를 입력해 주세요. 형식 : yyyy/MM/dd")
        checkout = input()
        checkout = checkout(checkin, checkout)
    }
}

