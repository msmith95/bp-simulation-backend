package com.michaeldsmithjr.bpsimulation.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "app.cors")
@ConstructorBinding
data class CorsProperties(
    val allowedOrigins: List<String>
)
