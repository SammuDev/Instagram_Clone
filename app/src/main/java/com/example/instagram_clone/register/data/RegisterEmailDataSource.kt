package com.example.instagram_clone.register.data

interface RegisterEmailDataSource {
    fun login(email: String, callback: RegisterEmailCallback) {}
}
