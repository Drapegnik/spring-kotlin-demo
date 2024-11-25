package com.drapegnik.demo.data.repository

import com.drapegnik.demo.data.entity.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository : JpaRepository<Room, Long> {
    fun findByNameIgnoreCase(name: String): Room?
}
