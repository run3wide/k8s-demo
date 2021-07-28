package com.run3wide.userapi.controller

import com.run3wide.userapi.dto.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/rest/users")
    fun getUsers(): List<User> {
        return listOf(
            User("Jeff"),
            User("Dale")
        )
    }
}
