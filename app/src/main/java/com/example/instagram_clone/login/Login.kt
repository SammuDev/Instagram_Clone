package com.example.instagram_clone.login

interface Login {
    // Camada view
    interface View {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticator()
        fun onUserUnauthorized()
    }
}
