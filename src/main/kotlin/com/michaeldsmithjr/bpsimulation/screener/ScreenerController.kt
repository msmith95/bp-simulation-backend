package com.michaeldsmithjr.bpsimulation.screener

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/screeners")
class ScreenerController(
    private val screenerService: ScreenerService
) {

    @PostMapping("/{screenerId}")
    fun processAnswers(@RequestBody screenerResponse: ScreenerResponse, @PathVariable screenerId: String): ScreenerResults {
        return screenerService.processResponse(screenerId, screenerResponse)
    }
}
