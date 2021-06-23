package com.michaeldsmithjr.bpsimulation.domain

import com.fasterxml.jackson.annotation.JsonCreator

enum class Domain(val id: String) {
    DEPRESSION("depression"),
    MANIA("mania"),
    ANXIETY("anxiety"),
    SUBSTANCE_USE("substance_use");

    companion object {

        @JsonCreator
        @JvmStatic
        fun fromJson(value: String): Domain? {
            return when (value) {
                "depression" -> DEPRESSION
                "mania" -> MANIA
                "anxiety" -> ANXIETY
                "substance_use" -> SUBSTANCE_USE
                else -> null
            }
        }
    }
}
