package com.drapegnik.demo.service

import com.drapegnik.demo.data.repository.GuestRepository
import com.drapegnik.demo.data.repository.ReservationRepository
import com.drapegnik.demo.data.repository.RoomRepository
import com.drapegnik.demo.service.model.RoomReservation
import org.springframework.stereotype.Service

@Service
class RoomReservationService(
    private var guestRepository: GuestRepository,
    private var roomRepository: RoomRepository,
    private var reservationRepository: ReservationRepository,
) {
    fun getRoomReservationsForDate(reservationDate: String): List<RoomReservation>? {
        val date: java.sql.Date
        try {
            date = java.sql.Date.valueOf(reservationDate)
        } catch (e: Exception) {
            return null
        }
        val roomReservationsMap = mutableMapOf<Long, RoomReservation>()

        val allRooms = roomRepository.findAll()
        allRooms.forEach {
            roomReservationsMap[it.id] =
                RoomReservation(
                    roomId = it.id,
                    roomName = it.name,
                    roomNumber = it.roomNumber,
                )
        }

        reservationRepository.findAllByReservationDate(date).forEach {
            val guest = guestRepository.findById(it.guestId).get()
            val room = roomRepository.findById(it.roomId).get()

            roomReservationsMap[it.roomId] =
                RoomReservation(
                    roomId = room.id,
                    guestId = guest.id,
                    reservationId = it.id,
                    roomName = room.name,
                    roomNumber = room.roomNumber,
                    firstName = guest.firstName,
                    lastName = guest.lastName,
                    reservationDate = reservationDate,
                )
        }

        return roomReservationsMap.values.toList()
    }
}
