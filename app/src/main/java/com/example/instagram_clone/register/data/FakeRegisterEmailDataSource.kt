package com.example.instagram_clone.register.data

import android.os.Handler
import android.os.Looper
import com.example.instagram_clone.common.model.Database

class FakeRegisterEmailDataSource : RegisterEmailDataSource {
    override fun login(email: String, callback: RegisterEmailCallback) {
        super.login(email, callback)

        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Database.userAuth.firstOrNull { email == it.email }

//            when {
//                userAuth == null -> {
//                    callback.onFailure("Usuário não encontrado!")
//                }
//                userAuth.password != password -> {
//                    callback.onFailure("Senha incorreta!")
//                }
//                else -> {
//                    Database.sessionAuth = userAuth
//                    callback.onSuccess(userAuth)
//                }
//            }

            callback.onComplete()
        }, 2000)
    }
}
