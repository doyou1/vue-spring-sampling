package com.jh.server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HomeController {

    @GetMapping("")
    fun default() : Map<String, String> {
        val map = mutableMapOf<String, String>();
        map["key"] = "value";
        return map
    }
    @GetMapping("/hello")
    fun hello() : Map<String, String> {
        val map = mutableMapOf<String, String>();
        map["key"] = "value";
        return map;
    }
}