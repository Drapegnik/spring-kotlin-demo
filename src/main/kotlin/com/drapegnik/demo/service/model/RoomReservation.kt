package com.drapegnik.demo.service.model

data class RoomReservation(
    val roomId: Long,
    val roomName: String,
    val roomNumber: String,
    val reservationId: Long? = null,
    val reservationDate: String? = null,
    val guestId: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
)
