package com.drapegnik.demo

import com.drapegnik.demo.data.repository.RoomRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CLRunner(private val roomRepository: RoomRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Hello, world!")

        val allRooms = roomRepository.findAll()
        val kingRoom = roomRepository.findByNameIgnoreCase("king")

        println("Found room: $kingRoom")
        println("All rooms:")
        allRooms.forEach { println(it) }
    }
}
