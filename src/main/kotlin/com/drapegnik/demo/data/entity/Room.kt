package com.drapegnik.demo.data.entity

import jakarta.persistence.*

@Entity
@Table(name = "rooms")
data class Room(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    val id: Long = 0,

    @Column(name = "name")
    val name: String = "",

    @Column(name = "room_number")
    val roomNumber: String = "",

    @Column(name = "bed_info")
    val bedInfo: String = ""
)


