package com.michaeldsmithjr.bpsimulation.screener

import org.springframework.data.jpa.repository.JpaRepository

interface ScreenerRepository: JpaRepository<Screener, String>