package com.run3wide.k8sdemo.orders.adapter

import com.run3wide.k8sdemo.orders.application.OrderService
import com.run3wide.k8sdemo.orders.dto.CreateOrderDto
import com.run3wide.k8sdemo.orders.dto.OrderDto
import org.springframework.web.bind.annotation.*

@RestController
class OrderController(
    private val orderService: OrderService,
) {

    @GetMapping("/rest/orders")
    fun getAll(): List<OrderDto> {
        return orderService.getAll()
    }

    @GetMapping("/rest/orders/{id}")
    fun get(@PathVariable id: String): OrderDto {
        return orderService.get(id)
    }

    @PostMapping("/rest/orders")
    fun create(@RequestBody dto: CreateOrderDto) {
        orderService.create(dto)
    }
}
