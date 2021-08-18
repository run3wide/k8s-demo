package com.run3wide.k8sdemo.orders.infrastructure

import com.run3wide.userapi.client.UserApiClient
import org.springframework.stereotype.Component

@Component
class UserApi(
    private val userApiClient: UserApiClient,
) {

    fun getUserName(id: String): String {
        return userApiClient.getUser(id).name
    }
}
