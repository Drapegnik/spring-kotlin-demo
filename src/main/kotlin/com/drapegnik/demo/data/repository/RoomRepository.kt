package com.drapegnik.demo.data.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.drapegnik.demo.data.entity.Room

interface RoomRepository : JpaRepository<Room, Long> {
    fun findByNameIgnoreCase(name: String): Room?
}
