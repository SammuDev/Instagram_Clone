package com.example.instagram_clone.login.data

import android.os.Handler
import android.os.Looper

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        super.login(email, password, callback)
        Handler(Looper.getMainLooper()).postDelayed({
            if (email == "a@a.com" && password == "123456789") {
                callback.onSucces()
            } else {
                callback.onFailure("Usuário não encontrado!")
            }
            callback.onComplete()
        }, 2000)
    }
}
