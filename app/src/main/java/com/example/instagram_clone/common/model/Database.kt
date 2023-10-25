package com.example.instagram_clone.common.model

import java.util.UUID

object Database {
    val userAuth = hashSetOf<UserAuth>()

    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "userA", "userA@gmail.com", "123456789"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "userB", "userB@gmail.com", "987654321"))

        sessionAuth = userAuth.first()
    }
}
