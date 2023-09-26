package com.example.instagram_clone.register.presentation

import com.example.instagram_clone.R
import com.example.instagram_clone.register.RegisterNameAndPassword
import com.example.instagram_clone.register.data.RegisterEmailCallback
import com.example.instagram_clone.register.data.RegisterEmailRepository

class RegisterNameAndPasswordPresenter(
    private var view: RegisterNameAndPassword.View?,
    private val repository: RegisterEmailRepository
) : RegisterNameAndPassword.Presenter {
    override fun create(email: String, name: String, password: String, confirm: String) {
        val isNameValid = name.length > 3
        val isPasswordValid = password.length > 8
        val isConfirmValid = password == confirm

        if (!isNameValid) {
            view?.displayNameFailure(R.string.invalid_name)
        } else {
            view?.displayNameFailure(null)
        }

        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

        if (!isConfirmValid) {
            view?.displayPasswordFailure(R.string.password_not_equal)
        } else {
            view?.displayPasswordFailure(null)
        }

        if (isNameValid && isPasswordValid && isConfirmValid) {
            view?.showProgress(true)

            repository.create(email, name, password, object : RegisterEmailCallback {
                override fun onSuccess() {
                    view?.onCreateSuccess(name)
                }

                override fun onFailure(message: String) {
                    view?.onCreateFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }
            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}
