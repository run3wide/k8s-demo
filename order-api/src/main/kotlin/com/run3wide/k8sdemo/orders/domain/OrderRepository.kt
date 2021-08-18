package com.run3wide.k8sdemo.orders.domain

interface OrderRepository {

    fun save(order: Order)

    fun get(orderId: OrderId): Order

    fun getAll(): List<Order>
}
