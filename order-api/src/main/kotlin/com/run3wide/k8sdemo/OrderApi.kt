package com.run3wide.k8sdemo

import com.run3wide.userapi.client.UserApiClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients(clients = [UserApiClient::class])
@SpringBootApplication
class OrderApi

fun main(args: Array<String>) {
    runApplication<OrderApi>(*args)
}
