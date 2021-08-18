package com.run3wide.userapi.domain

import java.util.*

class UserId private constructor(
    private val id: UUID = UUID.randomUUID()
) {

    val value: String = id.toString()

    companion object {
        fun generate(): UserId {
            return UserId()
        }

        fun build(id: String): UserId {
            return UserId(
                UUID.fromString(id)
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
