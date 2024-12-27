package com.drapegnik.demo.rest.api

import com.drapegnik.demo.service.RoomReservationService
import com.drapegnik.demo.service.model.RoomReservation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/reservations")
class ReservationApiController(
    val reservationService: RoomReservationService,
) {
    @GetMapping
    fun getAllReservationsByDate(
        @RequestParam(value = "date", required = true) dateString: String,
    ): List<RoomReservation> = reservationService.getRoomReservationsForDate(dateString)
}
