package com.drapegnik.demo.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "guests")
data class Guest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    val id: Long = 0,
    @Column(name = "first_name")
    val firstName: String = "",
    @Column(name = "last_name")
    val lastName: String = "",
    @Column(name = "email")
    val email: String = "",
    @Column(name = "address")
    val address: String = "",
    @Column(name = "country")
    val country: String = "",
    @Column(name = "state")
    val state: String = "",
    @Column(name = "phone_number")
    val phoneNumber: String = "",
)
