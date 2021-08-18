package com.run3wide.k8sdemo.orders.application

import com.run3wide.k8sdemo.orders.domain.Order
import com.run3wide.k8sdemo.orders.domain.OrderId
import com.run3wide.k8sdemo.orders.domain.OrderRepository
import com.run3wide.k8sdemo.orders.dto.CreateOrderDto
import com.run3wide.k8sdemo.orders.dto.OrderDto
import com.run3wide.k8sdemo.orders.infrastructure.UserApiClient
import org.springframework.stereotype.Component

@Component
class OrderService(
    private val orderRepository: OrderRepository,
    private val userApiClient: UserApiClient,
) {

    fun create(dto: CreateOrderDto) {
        val order = Order(
            dto.userId,
            dto.description
        )
        orderRepository.save(order)
    }

    fun get(id: String): OrderDto {
        val orderId = OrderId.build(id)
        return orderRepository.get(orderId).toDto()
    }

    fun getAll(): List<OrderDto> {
        return orderRepository.getAll()
            .map { it.toDto() }
    }

    private fun Order.toDto(): OrderDto {
        return OrderDto(
            id.value,
            userId,
            userApiClient.getUser(userId).name,
            description,
        )
    }
}
