package com.drapegnik.demo.rest.api

import com.drapegnik.demo.data.entity.Room
import com.drapegnik.demo.data.repository.RoomRepository
import com.drapegnik.demo.rest.exception.BadRequestException
import com.drapegnik.demo.rest.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rooms")
class RoomApiController(
    val roomRepository: RoomRepository,
) {
    @GetMapping
    fun getAllRooms() = roomRepository.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createRoom(
        @RequestBody room: Room,
    ) = roomRepository.save(room)

    @GetMapping("/{id}")
    fun getRoom(
        @PathVariable id: Long,
    ): Room {
        val room = roomRepository.findById(id)
        if (!room.isPresent) {
            throw NotFoundException("Room with id $id not found")
        }
        return room.get()
    }

    @PutMapping("/{id}")
    fun updateRoom(
        @PathVariable id: Long,
        @RequestBody room: Room,
    ): Room {
        if (id != room.id) {
            throw BadRequestException("Room id mismatch")
        }
        if (!roomRepository.existsById(id)) {
            throw NotFoundException("Room with id $id not found")
        }
        return roomRepository.save(room)
    }

    @DeleteMapping("/{id}")
    fun deleteRoom(
        @PathVariable id: Long,
    ) {
        if (!roomRepository.existsById(id)) {
            throw NotFoundException("Room with id $id not found")
        }
        roomRepository.deleteById(id)
    }
}
