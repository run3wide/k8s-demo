package com.run3wide.userapi.client

import com.run3wide.userapi.model.UserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "user-api-client", url = "\${api.user-api.url}")
interface UserApiClient {

    @GetMapping("/rest/users/{id}")
    fun getUser(@PathVariable id: String): UserDto

    @GetMapping("/rest/users")
    fun getAllUsers(): List<UserDto>
}
