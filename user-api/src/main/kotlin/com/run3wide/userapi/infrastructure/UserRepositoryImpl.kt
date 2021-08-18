package com.run3wide.userapi.infrastructure

import com.run3wide.userapi.domain.User
import com.run3wide.userapi.domain.UserId
import com.run3wide.userapi.domain.UserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryImpl : UserRepository {

    private val userMap = buildUsers()

    override fun get(userId: UserId): User {
        return userMap.getValue(userId)
    }

    override fun getAll(): List<User> {
        return userMap.values.toList()
    }

    private fun buildUsers(): Map<UserId, User> {
        return listOf("Jeff", "Dale", "David", "Richard")
            .map { User(it) }
            .associateBy { it.userId() }
    }
}
