package com.run3wide.k8sdemo.orders.domain

import java.util.*

class OrderId private constructor(
    private val id: UUID = UUID.randomUUID()
) {

    val value: String = id.toString()

    companion object {
        fun generate(): OrderId {
            return OrderId()
        }

        fun build(id: String): OrderId {
            return OrderId(
                UUID.fromString(id)
            )
        }
    }
}