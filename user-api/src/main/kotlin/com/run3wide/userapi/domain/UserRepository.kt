package com.run3wide.userapi.domain

interface UserRepository {

    fun getAll(): List<User>

    fun get(userId: UserId): User
}
