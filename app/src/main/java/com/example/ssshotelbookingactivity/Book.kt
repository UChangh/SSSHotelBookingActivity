package com.example.ssshotelbookingactivity

class Book {
    var name:String
    var roomno:Int
    var checkin:String
    var checkout:String

    constructor(_name:String, _roomno:Int, _checkin: String, _checkout:String) {
        name = _name
        roomno = _roomno
        checkin = _checkin
        checkout = _checkout
    }
}