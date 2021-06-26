package com.michaeldsmithjr.bpsimulation.screener

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface ScreenerRepository: JpaRepository<Screener, String> {

    @EntityGraph(attributePaths = ["content", "content.sections"])
    fun findWithAllById(id: String): Screener
}