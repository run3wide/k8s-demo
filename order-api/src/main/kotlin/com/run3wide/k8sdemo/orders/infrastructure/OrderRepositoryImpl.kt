package com.run3wide.k8sdemo.orders.infrastructure

import com.run3wide.k8sdemo.orders.domain.Order
import com.run3wide.k8sdemo.orders.domain.OrderId
import com.run3wide.k8sdemo.orders.domain.OrderRepository
import org.springframework.stereotype.Component

@Component
class OrderRepositoryImpl : OrderRepository {

    val orders: MutableMap<OrderId, Order> = mutableMapOf()

    override fun save(order: Order) {
        orders[order.id] = order
    }

    override fun get(orderId: OrderId): Order {
        return orders.getValue(orderId)
    }

    override fun getAll(): List<Order> {
        return orders.values.toList()
    }
}
