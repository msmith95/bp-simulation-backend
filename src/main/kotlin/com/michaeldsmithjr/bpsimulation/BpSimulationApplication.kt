package com.michaeldsmithjr.bpsimulation

import com.michaeldsmithjr.bpsimulation.configuration.CorsProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(CorsProperties::class)
class BpSimulationApplication

fun main(args: Array<String>) {
    runApplication<BpSimulationApplication>(*args)
}
