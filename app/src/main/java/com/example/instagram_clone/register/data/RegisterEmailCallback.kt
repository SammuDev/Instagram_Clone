package com.example.instagram_clone.register.data

import com.example.instagram_clone.common.model.UserAuth

interface RegisterEmailCallback {
    fun onSuccess()
    fun onFailure(message: String)
    fun onComplete()
}
