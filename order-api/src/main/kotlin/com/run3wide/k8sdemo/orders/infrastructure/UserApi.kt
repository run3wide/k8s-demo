package com.run3wide.k8sdemo.orders.infrastructure

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "user-api", url = "user-api.default.svc.cluster.local:8080")
interface UserApi {

    @GetMapping("/rest/users/{id}")
    fun getUser(@PathVariable id: String): UserDto

    @GetMapping("/rest/users")
    fun getAllUsers(): List<UserDto>
}

data class UserDto(
    val id: String,
    val name: String,
)
