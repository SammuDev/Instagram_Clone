package com.example.instagram_clone.login

import androidx.annotation.StringRes
import com.example.instagram_clone.common.base.BasePresenter
import com.example.instagram_clone.common.base.BaseView

interface Login {
    // Camada Presenter
    interface Presenter : BasePresenter {
        fun login(email: String, password: String)
    }

    // Camada view
    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onUserAuthenticator()
        fun onUserUnauthorized(message: String)
    }
}
