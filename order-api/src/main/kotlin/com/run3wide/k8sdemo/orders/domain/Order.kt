package com.run3wide.k8sdemo.orders.domain

class Order(
    val userId: String,
    val description: String,
) {

    val id: OrderId = OrderId.generate()
}
