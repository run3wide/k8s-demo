package com.run3wide.userapi.domain

class User(
    private var name: String,
) {

    private val userId: UserId = UserId.generate()

    fun name(): String {
        return name
    }

    fun userId(): UserId {
        return userId
    }
}
