package com.michaeldsmithjr.bpsimulation.screener

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/screeners")
class ScreenerController(
    private val screenerService: ScreenerService
) {

    @PostMapping
    fun processAnswers(@RequestBody screenerResponse: ScreenerResponse): ScreenerResults {
        return screenerService.processResponse(screenerResponse)
    }
}
