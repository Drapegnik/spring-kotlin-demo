package com.drapegnik.demo.data.repository

import com.drapegnik.demo.data.entity.Guest
import org.springframework.data.jpa.repository.JpaRepository

interface GuestRepository : JpaRepository<Guest, Long>
