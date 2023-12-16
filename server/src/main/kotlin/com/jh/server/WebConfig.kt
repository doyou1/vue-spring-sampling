package com.jh.server

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:8080")
                .allowedOrigins("https://vue-spring-sampling-9p6a.vercel.app/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTION")
    }
}