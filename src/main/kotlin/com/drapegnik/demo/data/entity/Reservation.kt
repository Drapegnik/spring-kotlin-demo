package com.drapegnik.demo.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Date

@Entity
@Table(name = "reservations")
data class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    val id: Long = 0,
    @Column(name = "room_id")
    val roomId: Long = 0,
    @Column(name = "guest_id")
    val guestId: Long = 0,
    @Column(name = "res_date")
    val reservationDate: Date = Date(System.currentTimeMillis()),
)
