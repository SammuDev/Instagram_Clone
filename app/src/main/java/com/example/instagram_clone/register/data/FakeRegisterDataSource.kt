package com.example.instagram_clone.register.data

import android.os.Handler
import android.os.Looper
import com.example.instagram_clone.common.model.Database
import com.example.instagram_clone.common.model.UserAuth
import java.util.UUID

class FakeRegisterDataSource : RegisterDataSource {
    override fun create(email: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callback.onSuccess()
            } else {
                callback.onFailure("Usuário já cadastrado")
            }

            callback.onComplete()
        }, 2000)
    }

    override fun create(email: String, name: String, password: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if (userAuth != null) {
                callback.onFailure("Usuário já existe")
            } else {
                val created = Database.userAuth.add(
                    UserAuth(UUID.randomUUID().toString(), name, email, password)
                )
                if (created) {
                    callback.onSuccess()
                } else {
                    callback.onFailure("Erro no servidor")
                }
            }

            callback.onComplete()
        }, 2000)
    }
}
