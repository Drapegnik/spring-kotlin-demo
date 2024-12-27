package com.drapegnik.demo.rest.api

import com.drapegnik.demo.data.entity.Guest
import com.drapegnik.demo.data.repository.GuestRepository
import com.drapegnik.demo.rest.exception.NotFoundException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/guests")
class GuestApiController(
    val guestRepository: GuestRepository,
) {
    @GetMapping
    fun getAllGuests() = guestRepository.findAll()

    @GetMapping("/{id}")
    fun getGuest(
        @PathVariable id: Long,
    ): Guest =
        guestRepository.findById(id).orElseThrow {
            NotFoundException("Guest with id $id not found")
        }

    @PostMapping
    fun createGuest(
        @RequestBody guest: Guest,
    ) = guestRepository.save(guest)

    @DeleteMapping("/{id}")
    fun deleteGuest(
        @PathVariable id: Long,
    ) = guestRepository.deleteById(id)
}
