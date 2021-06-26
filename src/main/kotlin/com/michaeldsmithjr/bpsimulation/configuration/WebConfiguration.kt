package com.michaeldsmithjr.bpsimulation.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfiguration(private val corsProperties: CorsProperties): WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins(*corsProperties.allowedOrigins.toTypedArray())
    }
}