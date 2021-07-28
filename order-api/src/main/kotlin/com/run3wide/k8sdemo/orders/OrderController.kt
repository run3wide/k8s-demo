package com.run3wide.k8sdemo.orders

import com.run3wide.k8sdemo.orders.dto.Order
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @GetMapping("/rest/orders")
    fun getAll(): List<Order> {
        return listOf(
            Order("guitar"),
            Order("book"),
        )
    }
}
