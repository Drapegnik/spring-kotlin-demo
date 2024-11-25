package com.drapegnik.demo.rest.health

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    private var counter = 0

    @GetMapping("/health")
    fun healthCheck(): HealthStatus {
        counter++
        return HealthStatus(counter, "UP")
    }
}
