package com.jh.server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/messages")
class MessageController {

    @GetMapping("/")
    fun default() : String {
        return "default"
    }
    @GetMapping("/hello")
    fun hello() : Map<String, String> {
        val map = mutableMapOf<String, String>();
        map["key"] = "value";
        return map;
    }
}