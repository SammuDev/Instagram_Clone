package com.example.instagram_clone.common.model

import java.util.UUID

object Database {
    val userAuth = hashSetOf<UserAuth>()

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "user1@gmail.com", "123456789"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "user2@gmail.com", "987654321"))
    }
}
