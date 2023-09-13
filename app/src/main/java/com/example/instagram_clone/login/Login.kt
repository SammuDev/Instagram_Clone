package com.example.instagram_clone.login

interface Login {
    // Camada Presenter
    interface Presenter {
        fun login(email: String, password: String)
    }

    // Camada view
    interface View {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticator()
        fun onUserUnauthorized()
    }
}
