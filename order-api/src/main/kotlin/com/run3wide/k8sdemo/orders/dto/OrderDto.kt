package com.run3wide.k8sdemo.orders.dto

data class OrderDto(
    val orderId: String,
    val userId: String,
    val userName: String,
    val description: String,
)
