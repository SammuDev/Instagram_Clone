package com.example.instagram_clone.login.presentation

import android.util.Patterns
import com.example.instagram_clone.R
import com.example.instagram_clone.login.Login

class LoginPresenter(private val view: Login.View) : Login.Presenter {
    override fun login(email: String, password: String) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.displayEmailFailure(R.string.invalid_email)
        } else {
            view.displayEmailFailure(null)
        }

        if (password.length < 8) {
            view.displayPasswordFailure(R.string.invalid_password)
        } else {
            view.displayPasswordFailure(null)
        }
    }
}
