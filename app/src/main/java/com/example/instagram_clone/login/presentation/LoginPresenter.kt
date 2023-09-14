package com.example.instagram_clone.login.presentation

import android.util.Patterns
import com.example.instagram_clone.R
import com.example.instagram_clone.login.Login
import com.example.instagram_clone.login.data.LoginCallback
import com.example.instagram_clone.login.data.LoginRepository

class LoginPresenter(private var view: Login.View?, private val repository: LoginRepository) :
    Login.Presenter {
    override fun login(email: String, password: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

        if (isPasswordValid && isEmailValid) {
            view?.showProgress(true)

            repository.login(email, password, object : LoginCallback {
                override fun onSucces() {
                    TODO("Not yet implemented")
                }

                override fun onFailure(message: String) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }
            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}
