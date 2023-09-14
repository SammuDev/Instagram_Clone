package com.example.instagram_clone.login.data

interface LoginDataSource {
    fun login(email: String, password: String, callback: LoginCallback) {}
}
