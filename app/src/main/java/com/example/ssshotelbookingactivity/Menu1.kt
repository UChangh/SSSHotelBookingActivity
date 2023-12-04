package com.example.ssshotelbookingactivity

import kotlin.random.Random


open class Menu1 {

    open fun menu1() {
        var roomlist = roomlists
        var booklist = booklists
        var checkin = ""
        var checkout = ""
        var booking:Person
        var personarray = Array<Any>(4) { }

        var name = input("name").toString()
        var roomno = input("roomno").toString().toInt()

        while(true) {
            when {
                roomno in roomlist -> {
                    println("선택하신 방은 예약이 가능합니다.")
                    break
                }
                roomno !in roomlist -> {
                    println("선택하신 방은 예약이 불가능합니다.")
                    println("다른 방을 입력해 주세요.")
                    roomno = input("roomno").toString().toInt()
                }
            }
        }
        println("Rooms : $roomlist\nBooks : $booklist")

        println("체크인 날짜를 입력해 주세요. 형식 : yyyy MM dd")
        checkin = readln()
        checkin = checkin(CheckDate().check(checkin))  // 만약 checkin이 처음에 return하지 못했을 경우(값이 수정되었을 경우)

        println("체크아웃 날짜를 입력해 주세요. 형식 : yyyy MM dd")
        checkout = readln()
        checkout = checkout(CheckDate().check(checkin), CheckDate().check(checkout))

        input("money")

        when (bookmoney(moneyrange)) {
            -1 -> {
                println("예약이 취소되었습니다.")
            }
            else -> {
                booklist.add(roomno)
                roomlist.set(roomlist.indexOf(roomno),0)

                booking = Person(name, roomno, checkin, checkout)
                personarray[0] = booking.name
                personarray[1] = booking.roomno
                personarray[2] = booking.checkin
                personarray[3] = booking.checkout
                list[list.size] = personarray
            }
        }
    }
}

val bookingPrice = Random.nextInt(1, 2001)

fun input(type:String): Any? {
    return when(type) {
        "name" -> {
            println("성함을 입력해 주세요.")
            while (true) {
                try {
                    var name = readln()
                    if(name.isNotEmpty()) {
                        return name
                    } else {
                        println("성함을 다시 입력해 주세요.")
                    }
                } catch (e: Exception) {
                    println("성함을 다시 입력해 주세요.")
                }
            }
        }
        "roomno" -> {
            println("방 번호를 입력해 주세요.")
            while (true) {
                try {
                    var roomno:String? = readln()
                    return roomno?.toInt() ?: -1
                } catch (e: Exception) {
                    println("방 번호를 다시 입력해 주세요.")
                }

            }
        }
        "money" -> {
            println("현재 소지금 : $moneyrange")
        }
        else -> "X"
    }
}

fun bookmoney(myMoney:Int):Int {
    var money = myMoney
    var values = money
    println("잔액 : $money")
    myMoney?.run {
        if(money >= bookingPrice) {
            println("[예약금 지불]: [${money} - ${bookingPrice}] = ${money - bookingPrice}")
            money -= bookingPrice
            println("예약이 완료되었습니다.")
            values = money
        } else {
            println("돈이 부족합니다.")
            values = -1
        }
    }
    return values
}

