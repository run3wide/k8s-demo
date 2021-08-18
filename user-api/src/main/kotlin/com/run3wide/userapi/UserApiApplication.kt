package com.run3wide.userapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class UserApiApplication

fun main(args: Array<String>) {
    runApplication<UserApiApplication>(*args)
}
