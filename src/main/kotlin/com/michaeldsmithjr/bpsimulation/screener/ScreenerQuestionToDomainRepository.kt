package com.michaeldsmithjr.bpsimulation.screener

import org.springframework.data.jpa.repository.JpaRepository

interface ScreenerQuestionToDomainRepository: JpaRepository<ScreenerQuestionToDomain, ScreenerQuestionToDomain.ScreenerQuestionToDomainId> {
    fun findAllById_ScreenerId(screenerId: String): List<ScreenerQuestionToDomain>
}
