package com.drapegnik.demo.data.repository

import com.drapegnik.demo.data.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import java.sql.Date

interface ReservationRepository : JpaRepository<Reservation, Long> {
    fun findByRoomId(roomId: Long): List<Reservation>

    fun findByGuestId(guestId: Long): List<Reservation>

    fun findAllByReservationDate(reservationDate: Date): List<Reservation>
}
