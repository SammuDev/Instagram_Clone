package com.example.instagram_clone.register.data

interface RegisterEmailDataSource {
    fun create(email: String, callback: RegisterEmailCallback) {}
}
