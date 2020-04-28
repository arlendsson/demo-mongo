package com.example.demomongo.security.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class WebController {
    @GetMapping("/")
    fun home(): String {
        return "home"
    }
    @GetMapping("/user")
    fun welcome(): String {
        return "user"
    }
    @GetMapping("/admin")
    fun admin(): String {
        return "admin"
    }
//    @GetMapping("/login")
    @RequestMapping("/login")
    fun login(): String {
        println("##### login")
        return "login"
    }
    @GetMapping("/403")
    fun error403(): String {
        return "403"
    }

}