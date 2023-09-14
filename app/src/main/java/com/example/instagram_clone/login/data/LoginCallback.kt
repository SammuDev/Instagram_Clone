package com.example.instagram_clone.login.data

interface LoginCallback {
    fun onSucces()
    fun onFailure(message: String)
    fun onComplete()
}
