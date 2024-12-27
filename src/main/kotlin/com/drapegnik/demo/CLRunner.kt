package com.drapegnik.demo

import com.drapegnik.demo.data.repository.GuestRepository
import com.drapegnik.demo.data.repository.ReservationRepository
import com.drapegnik.demo.data.repository.RoomRepository
import com.drapegnik.demo.service.RoomReservationService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CLRunner(
    private val roomRepository: RoomRepository,
    private val guestRepository: GuestRepository,
    private val reservationRepository: ReservationRepository,
    private val roomReservationService: RoomReservationService,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Hello, Kotlin!")

        println("\n*** ROOMS ***")
        val rooms = roomRepository.findAll()
        rooms.forEach { println(it) }

        println("\n*** GUESTS ***")
        val guests = guestRepository.findAll()
        guests.forEach { println(it) }

        println("\n*** RESERVATIONS ***")
        val reservations = reservationRepository.findAll()
        reservations.forEach { println(it) }

        val kingRoom = roomRepository.findByNameIgnoreCase("king")
        println("\nFound king room: $kingRoom")

        val reservation = reservationRepository.findAllByReservationDate(java.sql.Date.valueOf("2024-11-28"))
        println("\nFound reservation on 28.11: $reservation")

        val reservationsByDate = roomReservationService.getRoomReservationsForDate("2024-11-28")
        println("\n*** RESERVATIONS BY DATE ***")
        reservationsByDate?.forEach { println(it) }

        val date = "2024/11/28"
        if (roomReservationService.getRoomReservationsForDate(date) == null) {
            println("\nInvalid date: $date")
        }
    }
}
