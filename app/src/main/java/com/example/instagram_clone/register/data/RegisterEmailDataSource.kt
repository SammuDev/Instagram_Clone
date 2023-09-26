package com.example.instagram_clone.register.data

interface RegisterEmailDataSource {
    fun create(email: String, callback: RegisterEmailCallback)
    fun create(email: String, name:String, password: String, callback: RegisterEmailCallback)
}
