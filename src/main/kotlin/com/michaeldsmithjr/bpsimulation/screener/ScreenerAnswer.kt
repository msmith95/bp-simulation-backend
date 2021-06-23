package com.michaeldsmithjr.bpsimulation.screener

import com.fasterxml.jackson.annotation.JsonProperty

data class ScreenerAnswer(
    val value: Int,

    @field:JsonProperty("question_id")
    val questionId: String
)
