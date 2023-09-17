package com.example.instagram_clone.login.data

import com.example.instagram_clone.common.model.UserAuth

interface LoginCallback {
    fun onSuccess(userAuth: UserAuth)
    fun onFailure(message: String)
    fun onComplete()
}
