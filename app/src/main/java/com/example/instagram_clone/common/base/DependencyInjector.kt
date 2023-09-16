package com.example.instagram_clone.common.base

import com.example.instagram_clone.login.data.FakeDataSource
import com.example.instagram_clone.login.data.LoginRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }
}
