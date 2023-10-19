package com.example.instagram_clone.common.base

import com.example.instagram_clone.login.data.FakeDataSource
import com.example.instagram_clone.login.data.LoginRepository
import com.example.instagram_clone.register.data.FakeRegisterDataSource
import com.example.instagram_clone.register.data.RegisterRepository
import com.example.instagram_clone.splash.data.FakeLocalDataSource
import com.example.instagram_clone.splash.data.SplashRepository

object DependencyInjector {
    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }
}
