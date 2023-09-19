package com.example.instagram_clone.common.base

import com.example.instagram_clone.login.data.FakeDataSource
import com.example.instagram_clone.login.data.LoginRepository
import com.example.instagram_clone.register.data.FakeRegisterEmailDataSource
import com.example.instagram_clone.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }
}
