package com.run3wide.userapi.application

import com.run3wide.userapi.domain.User
import com.run3wide.userapi.domain.UserId
import com.run3wide.userapi.domain.UserRepository
import com.run3wide.userapi.dto.UserDto
import org.springframework.stereotype.Component

@Component
class UserService(
    private val userRepository: UserRepository,
) {

    fun getAll(): List<UserDto> {
        return userRepository.getAll()
            .map { it.toDto() }
    }

    fun get(id: String): UserDto {
        val userId = UserId.build(id)
        return userRepository.get(userId).toDto()
    }

    private fun User.toDto(): UserDto {
        return UserDto(
            userId().value,
            name(),
        )
    }

    companion object {
        private val USERS = listOf(
            "Jeff",
            "Dale",
        )
    }
}
