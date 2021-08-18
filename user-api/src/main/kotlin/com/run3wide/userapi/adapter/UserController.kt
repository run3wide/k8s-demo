package com.run3wide.userapi.adapter

import com.run3wide.userapi.application.UserService
import com.run3wide.userapi.dto.UserDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/rest/users")
    fun getUsers(): List<UserDto> {
        return userService.getAll()
    }

    @GetMapping("/rest/users/{id}")
    fun get(@PathVariable id: String): UserDto {
        return userService.get(id)
    }
}
