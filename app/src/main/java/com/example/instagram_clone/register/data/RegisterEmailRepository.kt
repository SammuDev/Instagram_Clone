package com.example.instagram_clone.register.data

class RegisterEmailRepository(private val dataSource: RegisterEmailDataSource) {
    fun create(email: String, callback: RegisterEmailCallback) {
        dataSource.create(email, callback)
    }
}
