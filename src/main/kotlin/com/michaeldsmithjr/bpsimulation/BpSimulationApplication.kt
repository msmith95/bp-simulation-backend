package com.michaeldsmithjr.bpsimulation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BpSimulationApplication

fun main(args: Array<String>) {
    runApplication<BpSimulationApplication>(*args)
}
