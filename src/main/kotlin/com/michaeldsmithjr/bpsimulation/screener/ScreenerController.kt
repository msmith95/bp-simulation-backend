package com.michaeldsmithjr.bpsimulation.screener

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/screeners")
class ScreenerController(
    private val screenerService: ScreenerService
) {

    /**
     * Handles incoming screener responses and sends them to the ScreenerService for processing
     * @param screenerResponse Screener response data
     * @param screenerId ID of the screener
     */
    @PostMapping("/{screenerId}")
    fun processAnswers(@RequestBody screenerResponse: ScreenerResponse, @PathVariable screenerId: String): ScreenerResults {
        return screenerService.processResponse(screenerId, screenerResponse)
    }

    @GetMapping("/{screenerId}")
    fun getScreener(@PathVariable screenerId: String): Screener {
        return screenerService.getScreener(screenerId)
    }
}
